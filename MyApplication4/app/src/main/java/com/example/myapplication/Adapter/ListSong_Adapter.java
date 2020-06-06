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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.myapplication.Activity.MainActivity.temp;

public class ListSong_Adapter  extends RecyclerView.Adapter<ListSong_Adapter.ViewHolder>{ // nho truyen vao adapter 1 cai view holder
    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public ListSong_Adapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_list_baihat,parent,false);
        return new ViewHolder(view); // truyen vao view de khoi tao dc cac view
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtTencasi.setText(baiHat.getCaSi());
        holder.txtindex.setText(position+1+"");

    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex,txtTenBaiHat,txtTencasi;
        ImageView imgiconlove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenBaiHat = itemView.findViewById(R.id.textviewtenbaihat);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txtTencasi = itemView.findViewById(R.id.textviewtencasi);
            imgiconlove = itemView.findViewById(R.id.imageviewiconlove);
            /// bat su kien khi chon bai hat
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Song",baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });

            /// xet like cho bai hat
            EventButtonLike();

        }
        public void EventButtonLike(){
            imgiconlove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (temp == true){
                        imgiconlove.setImageResource(R.drawable.iconloved);
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
                        imgiconlove.setEnabled(false);
                    }else{
                        Toast.makeText(context, "Bạn Chưa Đăng Nhập", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
