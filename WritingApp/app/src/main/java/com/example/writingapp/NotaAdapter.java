package com.example.writingapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dao.NotaDao;
import models.Nota;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private List<Nota> notas;
    private Context context;
    private NotaDao notaDao;

    public NotaAdapter(List<Nota> notas, NotaDao notaDao) {
        this.notas = notas;
        this.notaDao = notaDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.eTextNote.setText(nota.conteudo);

        holder.eTextNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nota.conteudo = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Thread(() -> notaDao.updateNota(nota)).start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public EditText eTextNote;

        public ViewHolder(View view) {
            super(view);
            eTextNote = view.findViewById(R.id.et_Note);
        }
    }
}