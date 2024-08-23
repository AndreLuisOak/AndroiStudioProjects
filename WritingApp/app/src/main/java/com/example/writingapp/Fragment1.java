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

import models.Livro;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Livro> livros;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String LIVROS_KEY = "livrosKey";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String savedLivros = sharedPreferences.getString(LIVROS_KEY, "");

        livros = new ArrayList<>();
        if (!savedLivros.isEmpty()) {
            for (String livroStr : savedLivros.split(";")) {
                String[] livroDetails = livroStr.split(",");
                if (livroDetails.length == 3) {
                    livros.add(new Livro(livroDetails[0], livroDetails[1], livroDetails[2]));
                }
            }
        }

        recyclerViewAdapter = new RecyclerViewAdapter(livros);
        recyclerView.setAdapter(recyclerViewAdapter);

        FloatingActionButton fabAdd = view.findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NotePage.class);
            startActivityForResult(intent, 1);
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            String titulo = data.getStringExtra("titulo");
            String autor = data.getStringExtra("autor");
            String sinopse = data.getStringExtra("sinopse");

            Livro novoLivro = new Livro(titulo, autor, sinopse);
            livros.add(novoLivro);

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            StringBuilder savedLivros = new StringBuilder();
            for (Livro livro : livros) {
                savedLivros.append(livro.titulo).append(",").append(livro.autor).append(",").append(livro.sinopse).append(";");
            }
            editor.putString(LIVROS_KEY, savedLivros.toString());
            editor.apply();

            recyclerViewAdapter.notifyDataSetChanged();
        }
    }
}