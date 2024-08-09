package com.example.writingapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotePage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepagelayout);

        String titulo = getIntent().getStringExtra("titulo");
        String sinopse = getIntent().getStringExtra("sinopse");

        EditText titulo_et = findViewById(R.id.titulo_tv);
        EditText sinopse_et = findViewById(R.id.sinopse_tv);

        titulo_et.setText(titulo);
        sinopse_et.setText(sinopse);
    }
}
