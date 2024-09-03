package com.example.writingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.NotaDao;
import database.AppDatabaseNote; // Importação do AppDatabaseNote
import models.Nota;

public class Fragment3 extends Fragment {

    private RecyclerView recyclerView;
    private NotaAdapter notaAdapter;
    private List<Nota> notas;
    private NotaDao notaDao;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String NOTAS_KEY = "notasKey";

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDatabaseNote db = AppDatabaseNote.getInstance(getContext());
        notaDao = db.notaDao();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        recyclerView = view.findViewById(R.id.rViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        executorService.execute(() -> {
            notas = new ArrayList<>(notaDao.getAllNotas());
            getActivity().runOnUiThread(() -> {
                notaAdapter = new NotaAdapter(notas, notaDao);
                recyclerView.setAdapter(notaAdapter);
            });
        });

        FloatingActionButton fabAddNote = view.findViewById(R.id.fab_add_note);
        fabAddNote.setOnClickListener(v -> {
            Nota novaNota = new Nota("");
            notas.add(novaNota);
            executorService.execute(() -> {
                notaDao.insertAll(novaNota);
                getActivity().runOnUiThread(() -> {
                    notaAdapter.notifyItemInserted(notas.size() - 1);
                });
            });
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}