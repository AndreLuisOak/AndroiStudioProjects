package com.example.provamobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    private int itemLayout;
    private List<Item> itens;

    public itemAdapter(int layoutid, List<Item> itens) {
        this.itemLayout = layoutid;
        this.itens = itens;
    }

    public int getItemCount() {
        return itens == null ? 0 : itens.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itens.get(position);
        holder.itemAddTitulo.setText(item.titulo);
        holder.itemAddDescricao.setText(item.descricao);
    }

    public void updateItens(List<Item> novosItens) {
        this.itens = novosItens;
        notifyDataSetChanged();
    }

    public Item getItensAtPosition(int position) {
        return itens.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemAddTitulo;
        public TextView itemAddDescricao;

        public ViewHolder(View itemAddView) {
            super(itemAddView);
            itemAddView.setOnClickListener(this);
            itemAddTitulo = itemAddView.findViewById(R.id.titulo);
            itemAddDescricao = itemAddView.findViewById(R.id.descricao);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item clicado", Toast.LENGTH_SHORT).show();
        }
    }

}
