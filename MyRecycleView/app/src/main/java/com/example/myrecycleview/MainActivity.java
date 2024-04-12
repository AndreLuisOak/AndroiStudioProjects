package com.example.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView r_view;

    String[] comidas = {"Frutas", "Vegetais", "Massas", "Carnes", "Bebidas", "Sobremesas"};
    String[] descricao = {"Frutas sempre frescas", "Vegetais direto da horta", "Massas como da Itália",
                        "Carnes macias direto do fogo", "Bebidas sempre geladas", "As melhores sobremesas"};
    int[] imageResources = {R.drawable.frutas, R.drawable.vegetais, R.drawable.massas,
            R.drawable.carnes, R.drawable.bebidas, R.drawable.sobremesas};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r_view = findViewById(R.id.r_view);
        ArrayList<menu>menuList = new ArrayList<>();

        menuArrayAdapter itemArrayAdapter = new menuArrayAdapter(R.layout.list_item, menuList);

        r_view.setLayoutManager(new LinearLayoutManager(this));
        r_view.setAdapter(itemArrayAdapter);

        for (int i = 0; i < comidas.length; i++) {
            if (i < imageResources.length) {
                int imageResource = imageResources[i];
                menuList.add(new menu(comidas[i], descricao[i], imageResource));
            } else {
                int defaultImageResource = R.drawable.ic_launcher_foreground;
                menuList.add(new menu(comidas[i], descricao[i], defaultImageResource));
            }
        }
    }
}