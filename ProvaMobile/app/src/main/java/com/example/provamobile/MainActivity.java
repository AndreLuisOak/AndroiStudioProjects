package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private itemAdapter adapter;
    private List<Item> itemList;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.R_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        adapter = new itemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        db = AppDatabase.getInstance(getApplicationContext());

        findViewById(R.id.novoItem).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityAdd.class);
            startActivity(intent);
        });
    }
}