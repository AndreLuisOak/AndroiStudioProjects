package com.example.writingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    String[] menu = {"Fragment1", "Fragment2", "Fragment3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(), getLifecycle()
        );

        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        viewPager = findViewById(R.id.viewPager2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager.setAdapter(myAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy(){
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(menu[position]);
                    }
                }).attach();
    }
}