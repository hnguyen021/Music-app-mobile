package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Activity.XemThemActivity;
import com.example.myapplication.Adapter.PlayList_Adapter;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_PlayList extends Fragment {
    View view;
    ListView listPlayList;
    TextView txtTitlePlayList;
    TextView txtviewmorePlaylist;
    PlayList_Adapter playList_adapter;
    ArrayList<PlayList> arrayListPlayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        listPlayList =view.findViewById(R.id.listviewplaylist);
        txtTitlePlayList =view.findViewById(R.id.txtviewtitleplaylist);
        txtviewmorePlaylist = view.findViewById(R.id.textviewmoreplaylist);
        GetData();
        txtviewmorePlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XemThemActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void GetData() {
        DataService dataService = APIservice.getService();

        Call<List<PlayList>> callback =dataService.GetPlayListForToDay();
        callback.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                arrayListPlayList = (ArrayList<PlayList>) response.body();
              //  Log.d("GGGGGGG",arrayListPlayList.get(0).getTenPlayList());
                playList_adapter = new PlayList_Adapter(getActivity(),android.R.layout.simple_list_item_1,arrayListPlayList);
                listPlayList.setAdapter(playList_adapter);
                setListViewHeightBasedOnChildren(listPlayList);

            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                //listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
