package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter.ViewPager_PlayMusic;
import com.example.myapplication.Fragment.Fragment_Dish_Music;
import com.example.myapplication.Fragment.Fragment_ListSong_ForMediaPlayer;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class PlayMusicActivity extends AppCompatActivity {
    int position = 0;
    Toolbar toolbarplaymusic;
    TextView txtTimeSong,txtTotalTimeSong;
    SeekBar skbarSong;
    ImageView imgPrev,imgNext,imgStop,imgPlay;
    ViewPager viewPagerplayMusic;
    public static ArrayList<BaiHat> baiHatArrayList = new ArrayList<>();
    public static ViewPager_PlayMusic adapter_playMusic;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      //  StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_play_music);
        Init();
        GetIntent();
        EventClick();
        KhoiTaoMediaPlayer();


    }
    private void KhoiTaoMediaPlayer() {
        //Uri uri =(Uri) baiHatArrayList.get(position).getLinkBaiHat();
        Uri myUri = Uri.parse(baiHatArrayList.get(position).getLinkBaiHat());
        mediaPlayer = MediaPlayer.create(PlayMusicActivity.this,myUri);
        //mediaPlayer.start();


    }
    private void UpDateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio= new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                ///update progress của skSong
                skbarSong.setProgress(mediaPlayer.getCurrentPosition());
                // kiểm tra bài hát đã kết thúc chưa nếu hết rồi thì next bài mới
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position ++;
                        if(mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        }

                        if(position> (baiHatArrayList.size()-1)){
                            position = 0;
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        imgPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                        UpDateTimeSong();
                    }
                });
                handler.postDelayed(this,500);


            }
        },100);
    }
    private void SetTimeTotal(){// hàm định dạng lại giờ và xét thời gian tổng hợp cho bài hát
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTotalTimeSong.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        // gán max của skSong  = mediaPlayer.getDuartion
        skbarSong.setMax(mediaPlayer.getDuration());
    }
    public void EventClick(){
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position ++;
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if(position> (baiHatArrayList.size()-1)){
                    position = 0;
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpDateTimeSong();
            }
        });
        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position --;
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if(position < 0){
                    position = baiHatArrayList.size()-1;
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                imgPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpDateTimeSong();
            }
        });
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                imgPlay.setImageResource(R.drawable.play);
                KhoiTaoMediaPlayer();
                SetTimeTotal();
            }
        });

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    //nếu đang phát thì cho pause và đổi hình
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.play);
                }else{
                    //đang ngừng thì phát đổi hình thành pause
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.pause);

                }
                SetTimeTotal();
                UpDateTimeSong();
               // imgDish.startAnimation(animation);

            }
        });
        skbarSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skbarSong.getProgress());
            }
        });
    }





    private void GetIntent() {
        Intent intent = getIntent();
        baiHatArrayList.clear();
        if(intent != null){
            if (intent.hasExtra("Song")) {
                BaiHat baiHat = intent.getParcelableExtra("Song");
                //Toast.makeText(PlayMusicActivity.this,baiHat.getTenBaiHat(),Toast.LENGTH_LONG).show();
                baiHatArrayList.add(baiHat);
            }
            if (intent.hasExtra("ListSong")) {

                ArrayList<BaiHat> ArrbaiHat = intent.getParcelableArrayListExtra("ListSong");
                baiHatArrayList = ArrbaiHat;
            }
        }

    }

    private void Init() {
         toolbarplaymusic =findViewById(R.id.toolbarplaymusic);
         txtTimeSong =findViewById(R.id.textViewTimeSong);
         txtTotalTimeSong =findViewById(R.id.textViewTimeTotal);
         skbarSong = findViewById(R.id.seekBarSong);
         imgPrev =findViewById(R.id.imageButtonPrev);
         imgNext =findViewById(R.id.imageButtonNext);
         imgStop =findViewById(R.id.imageButtonStop);
         imgPlay =findViewById(R.id.imageButtonPlay);
         viewPagerplayMusic = findViewById(R.id.viewpagerplaymusic);
         setSupportActionBar(toolbarplaymusic);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         toolbarplaymusic.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(mediaPlayer.isPlaying()){
                     //nếu đang phát thì cho pause và đổi hình
                     mediaPlayer.stop();
                     //mediaPlayer.release();

                    }
                 finish();

             }
         }); // back ve trang chu
         toolbarplaymusic.setTitleTextColor(Color.WHITE);
        adapter_playMusic = new ViewPager_PlayMusic(getSupportFragmentManager());
        adapter_playMusic.addFragment(new Fragment_ListSong_ForMediaPlayer());
        adapter_playMusic.addFragment(new Fragment_Dish_Music());
        viewPagerplayMusic.setAdapter(adapter_playMusic);



    }


}
