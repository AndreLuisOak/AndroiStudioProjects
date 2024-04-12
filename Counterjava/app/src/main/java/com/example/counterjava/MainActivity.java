package com.example.counterjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView tv_contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_contador = findViewById(R.id.tv_contador);
        tv_contador.setText("0");

        Button btnCalculadora = findViewById(R.id.btnCalculadora);

        btnCalculadora.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
            }
        });

        Button btnCounter = findViewById(R.id.btnCounter);
        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contador.setText(String.valueOf(contador));
            }
        });
    }
}
