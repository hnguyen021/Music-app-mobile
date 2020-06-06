package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.BannerAdapter;
import com.example.myapplication.Model.QuangCao;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter ;
    Runnable runnable;
    Handler handler;
    int curritem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_banner,container,false);
        Init();
        GetData(); // Lấy dữ liệu cho banner từ sever
        return view;

    }

    private void Init() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
    }

    private void GetData() {
        DataService dataService = APIservice.getService();
        Call<List<QuangCao>> callback = dataService.GetDataBanner();


        callback.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {

                    ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                    //Log.d("XXXXXXX",banners.get(0).getTenBaiHat());

                    bannerAdapter = new BannerAdapter(getActivity(),banners);
                    // bannerAdapter = new BannerAdapter(this,banners);
                    viewPager.setAdapter(bannerAdapter);

                    circleIndicator.setViewPager(viewPager);
                    handler = new Handler();
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            curritem  = viewPager.getCurrentItem();
                            curritem++;
                            if(curritem > viewPager.getAdapter().getCount()){
                                curritem = 0;
                            }
                            viewPager.setCurrentItem(curritem,true);
                            handler.postDelayed(runnable,4500);
                        }
                    };
                    handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

                Log.d("Ket Noi That Bai",t.toString());



            }
        });
    }
}
