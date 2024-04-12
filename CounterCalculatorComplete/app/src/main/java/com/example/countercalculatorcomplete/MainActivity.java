package com.example.countercalculatorcomplete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor = findViewById(R.id.et_valor);

        Button btn_contador = findViewById(R.id.btn_contador);
        btn_contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorInicialStr = et_valor.getText().toString();
                int valorInicial = Integer.parseInt(valorInicialStr);

                Intent intent = new Intent(MainActivity.this, ContadorCompleto.class);
                intent.putExtra("valorInicial", valorInicial);
                startActivity(intent);
            }
        });

        Button btn_calculadora = findViewById(R.id.btn_calculadora);
        btn_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraCompleta.class);
                startActivity(intent);
            }
        });

    }
}