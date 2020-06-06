package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ListSong_Adapter;
import com.example.myapplication.Model.Album;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.Model.QuangCao;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSongActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
   // Toolbar toolbar;
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    QuangCao quangCao;
    ImageView imgViewdanhsachbaihat; // hinh chinh giua~
    ArrayList<BaiHat> arrSong;
    ListSong_Adapter listSong_adapter;
    PlayList playList;
    Album album;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DataIntent();
        Init();
        GettingStartToolBar();
        if(quangCao != null && !quangCao.getTenBaiHat().equals("")){ // neu co quang cao thi
            setValueInView(quangCao.getTenBaiHat(),quangCao.getHinhBaiHat());
             GetDataBanner(quangCao.getIdQuangCao());
        }
        if(playList != null && !playList.getTenPlayList().equals("")){
           setValueInView(playList.getTenPlayList(),playList.getIconPlayList());
            GetDataPlayList(playList.getIdPlayList());

        }
        if(album != null && !album.getTenAlbum().equals("")){
           setValueInView(album.getTenAlbum(),album.getHinhAlbum());
            GetDataAlbum(album.getIdAlbum());

        }

    }

    private void GetDataAlbum(String idAlbum) {
        DataService dataService = APIservice.getService();
        Call<List<BaiHat>> callback = dataService.GetListSongForAlbum(idAlbum);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                arrSong = (ArrayList<BaiHat>) response.body();
                listSong_adapter = new ListSong_Adapter(ListSongActivity.this,arrSong);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(listSong_adapter);
                floatButtonClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }

    private void GetDataPlayList(String idPlayList) {
        DataService dataService = APIservice.getService();
        Call<List<BaiHat>> callback = dataService.GetListSongForPlayList(idPlayList);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
              arrSong = (ArrayList<BaiHat>) response.body();
              listSong_adapter = new ListSong_Adapter(ListSongActivity.this,arrSong);
              recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
              recyclerViewdanhsachbaihat.setAdapter(listSong_adapter);
                floatButtonClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }
    private void GetDataBanner(String idquangcao) {
        DataService dataService = APIservice.getService();
        Call<List<BaiHat>> callback = dataService.GetListSongForBanner(idquangcao);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                arrSong = (ArrayList<BaiHat>) response.body();
                listSong_adapter =new ListSong_Adapter(ListSongActivity.this,arrSong);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(listSong_adapter);
                floatButtonClick();
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });

    }

    private void setValueInView(String ten, final String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        Picasso.get().load(hinh).into(imgViewdanhsachbaihat);
      // Bitmap myImage = getBitmapFromURL(hinh);
      // setBackgroundV16Plus( myImage);
        //collapsingToolbarLayout.setBackground(hinh);
        new Thread(new Runnable() {
            public void run() {
                // a potentially time consuming task
                final Bitmap bitmap = getBitmapFromURL(hinh);

                collapsingToolbarLayout.post(new Runnable() {
                    public void run() {
                        setBackgroundV16Plus(bitmap);
                    }
                });
            }
        }).start();
    }

    @TargetApi(16)
    private void setBackgroundV16Plus(Bitmap bitmap) {
        collapsingToolbarLayout.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bitmap));

    }
    public Bitmap getBitmapFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

/*
* try {
            URL url = new URL(hinh);

            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
* */
    private void GettingStartToolBar() {
       // setSupportActionBar(toolbar);//tao tool bar de back ve trang chu
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    private void Init() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat = (RecyclerView) findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton =(FloatingActionButton) findViewById(R.id.floatingbutton);
        imgViewdanhsachbaihat =(ImageView)findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
               // Toast.makeText(this,"AAAAAAA"+quangCao.getTenBaiHat(),Toast.LENGTH_LONG).show();
            }
            if(intent.hasExtra("playlist")){
                playList = (PlayList) intent.getSerializableExtra("playlist");
                //Toast.makeText(this,playList.getTenPlayList(),Toast.LENGTH_LONG).show();

            }
            if(intent.hasExtra("album")){
                album = (Album) intent.getSerializableExtra("album");
               // Toast.makeText(this,album.getTenAlbum(),Toast.LENGTH_LONG).show();

            }
        }
    }
    public void floatButtonClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListSongActivity.this,PlayMusicActivity.class);
                intent.putExtra("ListSong",arrSong);
                startActivity(intent);
            }
        });
    }
}
