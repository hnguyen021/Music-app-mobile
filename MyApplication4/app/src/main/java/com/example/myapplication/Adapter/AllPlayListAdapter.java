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

import com.example.myapplication.Activity.ListSongActivity;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllPlayListAdapter  extends RecyclerView.Adapter<AllPlayListAdapter.ViewHolder>{
    Context context;
    ArrayList<PlayList> playListArrayList;

    public AllPlayListAdapter(Context context, ArrayList<PlayList> playListArrayList) {
        this.context = context;
        this.playListArrayList = playListArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_playlist,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayList playList = playListArrayList.get(position);
        Picasso.get().load(playList.getHinhNen()).into(holder.imgHinhAlbum);
        holder.txtTenPlayList.setText(playList.getTenPlayList());

    }

    @Override
    public int getItemCount() {
        return playListArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHinhAlbum;
        TextView txtTenPlayList;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imgHinhAlbum = itemView.findViewById(R.id.imageviewallplaylist);
            txtTenPlayList =itemView.findViewById(R.id.textviewtenallplaylist);
            imgHinhAlbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("playlist",playListArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
