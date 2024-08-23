package com.example.writingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import models.Livro;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Livro> livros;
    private Context context;

    public RecyclerViewAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Livro livro = livros.get(position);
        holder.tituloTv.setText(livro.titulo);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NotePage.class);
            intent.putExtra("titulo", livro.titulo);
            intent.putExtra("autor", livro.autor);
            intent.putExtra("sinopse", livro.sinopse);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloTv;

        public ViewHolder(View view) {
            super(view);
            tituloTv = view.findViewById(R.id.titulo_tv);
        }
    }
}