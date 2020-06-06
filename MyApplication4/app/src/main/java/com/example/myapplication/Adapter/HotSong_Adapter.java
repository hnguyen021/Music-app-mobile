package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.PlayMusicActivity;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.myapplication.Activity.MainActivity.temp;

public class HotSong_Adapter  extends RecyclerView.Adapter<HotSong_Adapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public HotSong_Adapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_baihat_hot,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat =baiHatArrayList.get(position);
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtcasi.setText(baiHat.getCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.imgHinhBH);


    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenBaiHat,txtcasi;
        ImageView imgHinhBH,imgluotthich;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathot);
            txtTenBaiHat = itemView.findViewById(R.id.textviewtenbaihathot);
            imgHinhBH = itemView.findViewById(R.id.imageviewBaiHatHot);
            imgluotthich = itemView.findViewById(R.id.imageviewLike);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Song", baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });

                imgluotthich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (temp == true){
                        imgluotthich.setImageResource(R.drawable.iconloved);
                        DataService dataService = APIservice.getService();
                        Call<String> callback = dataService.UpdateLike("1", baiHatArrayList.get(getPosition()).getIdBaiHat());
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                String result = response.body();
                                if (result.equals("Update Success")) {
                                    Toast.makeText(context, "You Liked It <3", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                        imgluotthich.setEnabled(false);
                        }else{
                            Toast.makeText(context, "Bạn Chưa Đăng Nhập", Toast.LENGTH_LONG).show();
                        }
                    }
                });


        }
    }
}
