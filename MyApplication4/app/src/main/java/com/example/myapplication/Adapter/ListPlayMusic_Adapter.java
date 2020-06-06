package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ListPlayMusic_Adapter extends RecyclerView.Adapter<ListPlayMusic_Adapter.ViewHoler> {
    Context context;
    ArrayList<BaiHat>baiHatArrayList;

    public ListPlayMusic_Adapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.dong_play_list_song,parent,false);


        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        BaiHat baiHat =baiHatArrayList.get(position);
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtTenCasi.setText(baiHat.getCaSi());
        holder.txtIndex.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        TextView txtIndex,txtTenBaiHat,txtTenCasi;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtIndex=itemView.findViewById(R.id.textviewdanhsachindex1);
            txtTenBaiHat=itemView.findViewById(R.id.textviewtenbaihat1);
            txtTenCasi=itemView.findViewById(R.id.textviewtencasi1);

        }
    }
}
