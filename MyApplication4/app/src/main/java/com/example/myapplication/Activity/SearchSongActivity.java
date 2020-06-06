package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Adapter.SearchSong_Adapter;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSongActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView txtkhongCoBaiHat;
    SearchSong_Adapter searchSong_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_song);
        Init();
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("keyword")){
                SearchByKeyWord(intent.getStringExtra("keyword"));
            }
        }




    }

    private void Init() {
        toolbar =findViewById(R.id.toolbarsearchans);
        recyclerView = findViewById(R.id.listmusicsearch);
        txtkhongCoBaiHat = findViewById(R.id.txtnodata);
    }
    private void SearchByKeyWord(String key){
        DataService dataService = APIservice.getService();
        Call<List<BaiHat>> callback = dataService.GetSearchSong(key);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();

                if(baiHatArrayList.size()>0) {
                    searchSong_adapter = new SearchSong_Adapter(SearchSongActivity.this, baiHatArrayList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchSongActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(searchSong_adapter);
                    txtkhongCoBaiHat.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                }
                else{
                    txtkhongCoBaiHat.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
