package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class ActivityAdd extends AppCompatActivity {

    private EditText novaTarefa;
    private EditText novaDescricao;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.itemaddlayout);

        novaTarefa = findViewById(R.id.novaTarefa);
        novaDescricao = findViewById(R.id.novaDescricao);

        Button btn_salvar = findViewById(R.id.salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){salvar();}
        });
    }

    private void salvar(){
        String titulo = novaTarefa.getText().toString();
        String descricao = novaDescricao.getText().toString();

        AppDatabase appDatabase = Room.databaseBuilder(this, AppDatabase.class, "itensDatabase")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        ItemDao itemDao = appDatabase.itemDao();


        if (titulo.isEmpty() || descricao.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Item novoItem = new Item(titulo, descricao);
        itemDao.insertAll(novoItem);

        novaTarefa.setText("");
        novaDescricao.setText("");

        List<Item> novosItens = itemDao.getAllItens();
        itemAdapter.updateItens(novosItens);

        Intent intent = new Intent(ActivityAdd.this, MainActivity.class);
        startActivity(intent);
    }

}
