package com.example.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

// custom view pager cho 2 fragment dish_play va list_play
public class ViewPager_PlayMusic extends FragmentPagerAdapter {
    public final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public ViewPager_PlayMusic(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
    public void addFragment(Fragment fragment){
        fragmentArrayList.add(fragment);
    }
}
