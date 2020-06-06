package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Model.ChuDe;
import com.example.myapplication.Model.ChuDeTheLoai;
import com.example.myapplication.Model.TheLoai;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_chude_theloai extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalscollview);
        txtxemthem = view.findViewById(R.id.textxemthem);
        txtxemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Phần Này Chưa Làm",Toast.LENGTH_LONG).show();
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIservice.getService();
        Call<ChuDeTheLoai> callback = dataService.GetCategoryToDay();
        callback.enqueue(new Callback<ChuDeTheLoai>() {
            @Override
            public void onResponse(Call<ChuDeTheLoai> call, Response<ChuDeTheLoai> response) {
                ChuDeTheLoai chuDeTheLoai = response.body();

                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(chuDeTheLoai.getChuDe());
              //  Log.d("KKKKKKKKKKKKKKK",chuDeTheLoai.getTheLoai().get(0).getHinhTheLoai());
                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(chuDeTheLoai.getTheLoai());
                LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(580,280);
                layoutParams.setMargins(10,20,10,30);
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                for(int i = 0;i<chuDeArrayList.size();i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(chuDeArrayList.get(i).getHinhChuDe()!=null){
                      //  Picasso.get().load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                        Picasso.get().load(chuDeArrayList.get(i).getHinhChuDe()).purgeable().into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getContext(),"Phần Này Chưa Làm",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                for(int j = 0;j<theLoaiArrayList.size();j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(j).getHinhTheLoai()!=null){
                        Picasso.get().load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<ChuDeTheLoai> call, Throwable t) {
                Log.d("KKKKKKKKKK",call.toString());

            }
        });
    }
}
