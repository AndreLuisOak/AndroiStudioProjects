package com.example.writingapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public MyViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
    }

    public Fragment createFragment(int position){
        return fragmentList.get(position);
    }

    public int getItemCount(){
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
}
