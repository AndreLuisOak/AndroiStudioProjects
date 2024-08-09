package com.example.writingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Livro;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Livro> livros;

    private static final String sharedPrefs = "sharedPrefs";
    private static final String livros_key = "livrosKey";

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(sharedPrefs, Context.MODE_PRIVATE);
        String savedLivros = sharedPreferences.getString(livros_key, "Livro 1,Autor 1,Sinopse 1");

        livros = new ArrayList<>();
        for (String livroStr : savedLivros.split(";")) {
            String[] livroDetails = livroStr.split(",");
            if (livroDetails.length == 3) {
                livros.add(new Livro(livroDetails[0], livroDetails[1], livroDetails[2]));
            }
        }

        recyclerViewAdapter = new RecyclerViewAdapter(livros);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}