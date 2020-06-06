package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.Activity.ListSongActivity;
import com.example.myapplication.Activity.MainActivity;
import com.example.myapplication.Model.QuangCao;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    Context context;
    ArrayList<QuangCao> arrayListBanner ;


    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBanner ) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;

    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_banner,null);
        ImageView imgbackgroundbanner = view.findViewById(R.id.imageBackgroundViewBanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitilesongbanner = view.findViewById(R.id.textviewtitlebannerbaihat);
        TextView txtnoidungbanner = view.findViewById(R.id.textviewnoidungbanner);


        Picasso.get().load(arrayListBanner.get(position).getHinhAnhQC()).into(imgbackgroundbanner);
        //Log.d("LLLLLLLLLL",arrayListBanner.get(2).getHinhAnhQC());
        Picasso.get().load(arrayListBanner.get(position).getHinhBaiHat()).into(imgsongbanner);
        txttitilesongbanner.setText(arrayListBanner.get(position).getTenBaiHat());
        txtnoidungbanner.setText(arrayListBanner.get(position).getNoiDungQC());

        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListSongActivity.class);
                intent.putExtra("banner",  arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
