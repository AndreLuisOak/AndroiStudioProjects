package com.example.writingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PersonagemAddPage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpersonagemlayout);

        EditText nomeEt = findViewById(R.id.et_Nome);
        EditText idadeEt = findViewById(R.id.et_Idade);
        EditText generoEt = findViewById(R.id.et_Genero);
        EditText aparenciaEt = findViewById(R.id.et_Aparencia);
        EditText personalidadeEt = findViewById(R.id.et_Personalidade);
        Button btnSalvar = findViewById(R.id.buttonSave);

        btnSalvar.setOnClickListener(v -> {
            String nome = nomeEt.getText().toString();
            int idade = Integer.parseInt(idadeEt.getText().toString()); // Converte para int
            String genero = generoEt.getText().toString();
            String aparencia = aparenciaEt.getText().toString();
            String personalidade = personalidadeEt.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("nome", nome);
            intent.putExtra("idade", idade);
            intent.putExtra("genero", genero);
            intent.putExtra("aparencia", aparencia);
            intent.putExtra("personalidade", personalidade);
            setResult(RESULT_OK, intent);
            finish();
        });

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        int idade = intent.getIntExtra("idade", 0);
        String genero = intent.getStringExtra("genero");
        String aparencia = intent.getStringExtra("aparencia");
        String personalidade = intent.getStringExtra("personalidade");

        nomeEt.setText(nome);
        idadeEt.setText(String.valueOf(idade));
        generoEt.setText(genero);
        aparenciaEt.setText(aparencia);
        personalidadeEt.setText(personalidade);
    }
}