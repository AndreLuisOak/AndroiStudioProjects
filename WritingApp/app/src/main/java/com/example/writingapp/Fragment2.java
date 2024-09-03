package com.example.writingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import models.Personagem;

public class Fragment2 extends Fragment {
    private RecyclerView rv_personagens;
    private PersonagemAdapter personagemAdapter;
    private List<Personagem> personagens;

    private static final String SHARED_PREFS = "sharedPrefs_personagem";
    private static final String PERSONAGENS_KEY = "personagensKey";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        rv_personagens = view.findViewById(R.id.rv_personagens);
        rv_personagens.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String savedPersonagens = sharedPreferences.getString(PERSONAGENS_KEY, "");

        personagens = new ArrayList<>();
        if (!savedPersonagens.isEmpty()) {
            for (String personagemStr : savedPersonagens.split(";")) {
                String[] personagemDetails = personagemStr.split(",");
                if (personagemDetails.length == 5) {
                    String nome = personagemDetails[0];
                    int idade = Integer.parseInt(personagemDetails[1]);
                    String genero = personagemDetails[2];
                    String aparencia = personagemDetails[3];
                    String personalidade = personagemDetails[4];
                    personagens.add(new Personagem(nome, idade, genero, aparencia, personalidade));
                }
            }
        }

        personagemAdapter = new PersonagemAdapter(personagens);
        rv_personagens.setAdapter(personagemAdapter);

        FloatingActionButton fabAddPersonagem = view.findViewById(R.id.fabAddPersonagem);
        fabAddPersonagem.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PersonagemAddPage.class);
            startActivityForResult(intent, 1);
        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            String nome = data.getStringExtra("nome");
            int idade = data.getIntExtra("idade", 0);
            String genero = data.getStringExtra("genero");
            String aparencia = data.getStringExtra("aparencia");
            String personalidade = data.getStringExtra("personalidade");

            Personagem newPersonagem = new Personagem(nome, idade, genero, aparencia, personalidade);
            personagens.add(newPersonagem);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            StringBuilder savedPersonagens = new StringBuilder();
            for (Personagem personagem : personagens) {
                savedPersonagens.append(personagem.nome).append(",").append(personagem.idade).append(",").append(personagem.genero).append(",")
                        .append(personagem.aparencia).append(",").append(personagem.personalidade).append(";");
            }
            editor.putString(PERSONAGENS_KEY, savedPersonagens.toString());
            editor.apply();

            personagemAdapter.notifyDataSetChanged();
        }
    }
}