package com.example.provamobilecorrigida;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.ViewHolder> {
    private List<Tarefa> tarefas;

    public TarefaAdapter(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void updateTarefas(List<Tarefa> novasTarefas) {
        this.tarefas = novasTarefas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarefaitem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefas.get(position);
        holder.textViewTitle.setText(tarefa.titulo);
        holder.textViewDescription.setText(tarefa.descricao);
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tv_titulo);
            textViewDescription = itemView.findViewById(R.id.tv_descricao);
        }
    }
}
