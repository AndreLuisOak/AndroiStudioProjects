package com.example.provamobilecorrigida;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TarefaDatabase tarefaDatabase;
    private TarefaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_tarefas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        tarefaDatabase = Room.databaseBuilder(getApplicationContext(),
                        TarefaDatabase.class, "tarefa_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<Tarefa> tarefas = tarefaDatabase.tarefaDao().getAllTasks();
        adapter = new TarefaAdapter(tarefas);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTarefaActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Tarefa tarefa = new Tarefa(data.getStringExtra("titulo"), data.getStringExtra("descricao"));
            tarefaDatabase.tarefaDao().insert(tarefa);

            List<Tarefa> tarefas = tarefaDatabase.tarefaDao().getAllTasks();
            adapter.updateTarefas(tarefas);
            adapter.notifyDataSetChanged();
        }
    }
}
