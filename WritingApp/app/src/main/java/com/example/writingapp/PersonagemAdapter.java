package com.example.writingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import models.Personagem;

public class PersonagemAdapter extends RecyclerView.Adapter<PersonagemAdapter.ViewHolder> {
    private List<Personagem> personagens;
    private Context context;

    public PersonagemAdapter(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_personagem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personagem personagem = personagens.get(position);
        holder.tv_nome.setText(personagem.nome);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonagemAddPage.class);
            intent.putExtra("nome", personagem.nome);
            intent.putExtra("idade", personagem.idade);
            intent.putExtra("genero", personagem.genero);
            intent.putExtra("aparencia", personagem.aparencia);
            intent.putExtra("personalidade", personagem.personalidade);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return personagens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_nome;

        public ViewHolder(View view) {
            super(view);
            tv_nome = view.findViewById(R.id.tv_Nome);
        }
    }
}