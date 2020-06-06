package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.PlayMusicActivity;
import com.example.myapplication.Adapter.ListPlayMusic_Adapter;
import com.example.myapplication.R;

public class Fragment_ListSong_ForMediaPlayer  extends Fragment {
    View view;
    RecyclerView recyclerView;
    ListPlayMusic_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listsong_formediaplayer,container,false);
        recyclerView=view.findViewById(R.id.recycleviewlistforplaymusic);
        if(PlayMusicActivity.baiHatArrayList.size()>0){
            adapter = new ListPlayMusic_Adapter(getActivity(), PlayMusicActivity.baiHatArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
