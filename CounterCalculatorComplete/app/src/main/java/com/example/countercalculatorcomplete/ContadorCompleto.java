package com.example.countercalculatorcomplete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContadorCompleto extends AppCompatActivity {

    private TextView tv_contadorC;

    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_completo);

        tv_contadorC = findViewById(R.id.tv_contadorC);
        contador = getIntent().getIntExtra("valorInicial", 0);
        tv_contadorC.setText(String.valueOf(contador));

        Button btn_contadorC = findViewById(R.id.btn_contadorC);
        btn_contadorC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contadorC.setText(String.valueOf(contador));
            }
        });

    }
}