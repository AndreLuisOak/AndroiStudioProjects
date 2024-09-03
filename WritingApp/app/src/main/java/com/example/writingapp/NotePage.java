package com.example.writingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotePage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepagelayout);

        EditText tituloEt = findViewById(R.id.titulo_et);
        EditText autorEt = findViewById(R.id.autor_et);
        EditText sinopseEt = findViewById(R.id.sinopse_et);
        Button btnSalvar = findViewById(R.id.btn_salvar);

        btnSalvar.setOnClickListener(v -> {
            String titulo = tituloEt.getText().toString();
            String autor = autorEt.getText().toString();
            String sinopse = sinopseEt.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("titulo", titulo);
            intent.putExtra("autor", autor);
            intent.putExtra("sinopse", sinopse);
            setResult(RESULT_OK, intent);
            finish();
        });

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String autor = intent.getStringExtra("autor");
        String sinopse = intent.getStringExtra("sinopse");

        tituloEt.setText(titulo);
        autorEt.setText(autor);
        sinopseEt.setText(sinopse);
    }

}