package com.example.provamobilecorrigida;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class AddTarefaActivity extends AppCompatActivity {

    private EditText et_Titulo;
    private EditText et_Descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtarefa);

        et_Titulo = findViewById(R.id.et_Titulo);
        et_Descricao = findViewById(R.id.et_Descricao);
        Button buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("titulo", et_Titulo.getText().toString());
            resultIntent.putExtra("descricao", et_Descricao.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

