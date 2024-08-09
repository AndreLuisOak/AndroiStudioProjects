package com.example.exemplos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Contador e calculadora
    //priavte edittext et_valor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tv_palavra), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //Button
        /*Button btn_contador = findViewById(R.id.btn_contador);
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
        });*/
        /*package com.example.listapp;

   LISTVIEW
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    ListView lv_planets;

    String[] planetas = {"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno"};
    String[] luas = {"Luas: 0", "Luas: 0", "Luas: 1", "Luas: 2", "Luas: 79", "Luas: 145", "Luas: 27", "Luas: 14"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_planets = findViewById(R.id.lv_planets);

        ListViewCustomAdapter adapter = new ListViewCustomAdapter(this, planetas, luas);
        lv_planets.setAdapter(adapter);

        lv_planets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message = "Planeta: " + planetas[position] + "\n" + "é o " + (position+1) + "° \n" + " planeta do sistema solar";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

MEDIA PLAYER
package com.example.musicapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
            AirplaneModeReceiver br = new AirplaneModeReceiver();
            registerReceiver(br, intentFilter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn_start, btn_stop;
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("André", "start music button");
                Intent startMusic = new Intent(v.getContext(), MusicBackgroundService.class);
                startService(startMusic);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("André", "stop music button");
                Intent stopMusicIntent = new Intent(v.getContext(), MusicBackgroundService.class);
                stopService(stopMusicIntent);
            }
        });
    }
}

CARD VIEW
package com.example.mycardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_info = findViewById(R.id.rv_info);
        ArrayList<model> modelList = new ArrayList<>();
        cardAdapter cAdapter = new cardAdapter(modelList);

        model news1 = new model("Gato", "Animal fofo que ensina a não ser grudadento com que se ama", R.drawable.cat);
        model news2 = new model("Cachorro", "Leal, brincalhão e que responde por entonação de voz", R.drawable.dog);
        model news3 = new model("Passáro", "O Brasil é um dos países onde mais podemos encontrar espécies raras, ao todo, existem cerca de 300 espécies endêmicas", R.drawable.bird);
        model news4 = new model("Peixinho dourado", "Sem luz do sol peixes dourados perdem a cor", R.drawable.fish);
        model news5 = new model("Lagarto", "Lagartos vivem em terrários", R.drawable.lizard);

        modelList.add(news1);
        modelList.add(news2);
        modelList.add(news3);
        modelList.add(news4);
        modelList.add(news5);


        rv_info.setLayoutManager(new LinearLayoutManager(this));
        rv_info.setAdapter(cAdapter);
    }
}

RECYCLER VIEW
package com.example.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView r_view;

    String[] comidas = {"Frutas", "Vegetais", "Massas", "Carnes", "Bebidas", "Sobremesas"};
    String[] descricao = {"Frutas sempre frescas", "Vegetais direto da horta", "Massas como da Itália",
                        "Carnes macias direto do fogo", "Bebidas sempre geladas", "As melhores sobremesas"};
    int[] imageResources = {R.drawable.frutas, R.drawable.vegetais, R.drawable.massas,
            R.drawable.carnes, R.drawable.bebidas, R.drawable.sobremesas};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r_view = findViewById(R.id.r_view);
        ArrayList<menu>menuList = new ArrayList<>();

        menuArrayAdapter itemArrayAdapter = new menuArrayAdapter(R.layout.list_item, menuList);

        r_view.setLayoutManager(new LinearLayoutManager(this));
        r_view.setAdapter(itemArrayAdapter);

        for (int i = 0; i < comidas.length; i++) {
            if (i < imageResources.length) {
                int imageResource = imageResources[i];
                menuList.add(new menu(comidas[i], descricao[i], imageResource));
            } else {
                int defaultImageResource = R.drawable.ic_launcher_foreground;
                menuList.add(new menu(comidas[i], descricao[i], defaultImageResource));
            }
        }
    }
}

VIEWPAGER2 E FRAGMENT
package com.mastercoding.viewpagerapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    String[] menu = {"Fragment 1", "Fragment 2", "Fragment 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        // Adding Fragments to the list in the Adapter Class
        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        // Set the orientation in ViewPager2
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Connecting the Adapter with ViewPager2
        viewpager.setAdapter(myAdapter);

        // Connecting TabLayout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(menu[position]);
                    }
                }
        ).attach();



    }
}

ROOMDATABASE
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
*/
}