package br.ufc.quixada.usoroomdatabase;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import br.ufc.quixada.usoroomdatabase.dao.PessoaDao;
import br.ufc.quixada.usoroomdatabase.database.AppDatabase;
import br.ufc.quixada.usoroomdatabase.models.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText et_Nome, et_Curso, et_Idade;
    PessoaDao pessoaDao;
    itemAddAdapter itemAddAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        et_Nome = findViewById(R.id.et_Nome);
        et_Curso = findViewById(R.id.et_Curso);
        et_Idade = findViewById(R.id.et_Idade);

        AppDatabase appDatabase = Room.databaseBuilder(this, AppDatabase.class, "db_pessoas")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        pessoaDao = appDatabase.pessoaDao();

        List<Pessoa> pessoasDoBd = pessoaDao.getAllPessoas();
        itemAddAdapter = new itemAddAdapter(R.layout.item, pessoasDoBd);
        recyclerView.setAdapter(itemAddAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeToDelete();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPessoa();
            }
        });
    }

    private void addPessoa() {
        String nome = et_Nome.getText().toString();
        String curso = et_Curso.getText().toString();
        int idade;

        try {
            idade = Integer.parseInt(et_Idade.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Idade inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if (nome.isEmpty() || curso.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Pessoa novaPessoa = new Pessoa(nome, curso, idade);
        pessoaDao.insertAll(novaPessoa);

        et_Nome.setText("");
        et_Curso.setText("");
        et_Idade.setText("");

        List<Pessoa> pessoasAtualizadas = pessoaDao.getAllPessoas();
        itemAddAdapter.updatePessoas(pessoasAtualizadas);
    }

    private void swipeToDelete() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Pessoa pessoa = itemAddAdapter.getPessoaAtPosition(position);

                pessoaDao.delete(pessoa);

                List<Pessoa> pessoasAtualizadas = pessoaDao.getAllPessoas();
                itemAddAdapter.updatePessoas(pessoasAtualizadas);

                Toast.makeText(MainActivity.this, "Pessoa deletada", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }
}