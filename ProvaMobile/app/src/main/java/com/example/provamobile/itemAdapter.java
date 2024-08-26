package com.example.provamobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    private int itemLayout;
    private List<Item> itens;

    public itemAdapter(List<Item> itens) {
        this.itemLayout = itemLayout;
        this.itens = itens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itens.get(position);
        holder.itemAddTitulo.setText(item.getTitulo());
        holder.itemAddDescricao.setText(item.getDescricao());
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public void updateItens(List<Item> novosItens) {
        this.itens = novosItens;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemAddTitulo;
        public TextView itemAddDescricao;

        public ViewHolder(View itemView) {
            super(itemView);
            itemAddTitulo = itemView.findViewById(R.id.titulo);
            itemAddDescricao = itemView.findViewById(R.id.descricao);
        }
    }
}