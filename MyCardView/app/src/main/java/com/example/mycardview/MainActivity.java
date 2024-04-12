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