package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.HotSong_Adapter;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_BaiHat extends Fragment {
    View view;
    RecyclerView recyclerView;
    HotSong_Adapter hotSong_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_hot,container,false);
        recyclerView = view.findViewById(R.id.recyclerviewBaiHatHot);
        GetData();

        return view;
    }

    private void GetData() {
        DataService dataService = APIservice.getService();
        Call<List<BaiHat>> callback = dataService.GetFavoriteSong();
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();
               // Log.d("FFFFFFFFFFFFF",baiHatArrayList.get(0).getTenBaiHat());
                hotSong_adapter = new HotSong_Adapter(getActivity(),baiHatArrayList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(hotSong_adapter);


            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
