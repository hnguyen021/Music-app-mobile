package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.Adapter.AllPlayListAdapter;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XemThemActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    AllPlayListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_them);
        Init();
        GetData();
        
    }

    private void GetData() {
        DataService dataService = APIservice.getService();// khởi tạo retrofit
        Call<List<PlayList>> callback = dataService.GetAllPlayList();
        callback.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> arrPlayList = (ArrayList<PlayList>) response.body();
                adapter = new AllPlayListAdapter(XemThemActivity.this,arrPlayList);
                recyclerView.setLayoutManager(new GridLayoutManager(XemThemActivity.this,2));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });

    }

    private void Init() {
        toolbar = findViewById(R.id.toolbarxemthem);
        recyclerView = findViewById(R.id.recyclerviewxemthem);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
