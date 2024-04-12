package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv_comidas;
    String[] comidas = {"Baiao", "Pamonha", "Feijoada", "Buchada", "Panelada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewCustomAdapter adapter = new ListViewCustomAdapter(this, comidas);
            listView.setAdapter(adapter);


    }
}