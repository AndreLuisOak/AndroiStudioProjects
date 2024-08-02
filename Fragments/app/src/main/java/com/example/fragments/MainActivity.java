package com.example.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    String[] menu = {"Pessoal", "Profissional", "Detalhes"};
    private String pessoal_pokemon = "Pessoal";
    private String profissional_pokemon = "Profissional";
    private String detalhes_pokemon = "Detalhes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewpager.setAdapter(myAdapter);

        new TabLayoutMediator(tabLayout, viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(menu[position]);
                    }
                }).attach();

        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(pessoal_pokemon, "Um dia típico de Snorlax consiste em nada mais do que comer e dormir. " +
                "É um Pokémon tão dócil que há crianças que usam sua barriga expansiva como um lugar para brincar.");
        editor.putString(profissional_pokemon, "Body Slam: 85 \n" + "Rest: -- \n" + "Snore: 50 \n" + "Sleep Talk: -- \n");
        editor.putString(detalhes_pokemon, "Base stats: 540 \n" + "HP: 160 \n" + "Attack: 110 \n" +
                "Defense: 65 \n" + "Sp. Attack: 65 \n" + "Sp. Defense: 110 \n" + "Speed: 30");
        editor.apply();
    }
}