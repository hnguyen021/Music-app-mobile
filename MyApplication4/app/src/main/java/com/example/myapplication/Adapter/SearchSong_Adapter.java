package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.PlayMusicActivity;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchSong_Adapter extends RecyclerView.Adapter<SearchSong_Adapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat>baiHatArrayList;

    public SearchSong_Adapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //anh xa va gan lai layout cho moi dong item
        LayoutInflater inflater =LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.dong_search_song,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat =baiHatArrayList.get(position);
        holder.txtTenBaiHat.setText(baiHat.getTenBaiHat());
        holder.txtSTT.setText(position+1+"");
        holder.txtTenCasi.setText(baiHat.getCaSi());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.imgHinhBaiHat);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenBaiHat,txtTenCasi,txtSTT;
        ImageView imgHinhBaiHat,imgIconLove;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtTenBaiHat= itemView.findViewById(R.id.textviewtenbaihatforsearch);
            txtTenCasi= itemView.findViewById(R.id.textviewtencasiforsearch);
            txtSTT= itemView.findViewById(R.id.textviewdanhsachindexforsearch);
            imgHinhBaiHat=itemView.findViewById(R.id.imageviewhinhbaihatforsearch);
            imgIconLove= itemView.findViewById(R.id.imageviewiconloveforsearch);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("Song",baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
