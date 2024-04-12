package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    ListView lv_planets;

    String[] planetas = {"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno"};
    String[] luas = {"Luas: 0", "Luas: 0", "Luas: 1", "Luas: 2", "Luas: 79", "Luas: 145", "Luas: 27", "Luas: 14"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_planets = findViewById(R.id.lv_planets);

        ListViewCustomAdapter adapter = new ListViewCustomAdapter(this, planetas, luas);
        lv_planets.setAdapter(adapter);

        lv_planets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = "Planeta: " + planetas[position] + "\n" + "é o " + (position+1) + "° \n" + " planeta do sistema solar";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
