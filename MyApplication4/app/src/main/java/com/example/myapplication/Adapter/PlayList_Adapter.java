package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Activity.ListSongActivity;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayList_Adapter extends ArrayAdapter<PlayList> {
    public PlayList_Adapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }
    private class ViewHolder{
        TextView txtTenPlayList;
        ImageView imgViewPlayList;
        ImageView imgViewBackground;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder =null;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView =layoutInflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.imgViewBackground = convertView.findViewById(R.id.imageviewbackgroundplaylist);
            viewHolder.imgViewPlayList = convertView.findViewById(R.id.imageviewplaylist);
            viewHolder.txtTenPlayList =convertView.findViewById(R.id.textviewtenplaylist);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PlayList playList = getItem(position);

        //viewHolder.imgViewBackground.setImageResource(playList.getHinhNen());

        Picasso.get().load(playList.getHinhNen()).placeholder(R.drawable.iconlove).into(viewHolder.imgViewBackground);
        Picasso.get().load(playList.getIconPlayList()).into(viewHolder.imgViewPlayList);
        viewHolder.txtTenPlayList.setText(playList.getTenPlayList());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListSongActivity.class);
                intent.putExtra("playlist",  playList);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
