package br.ufc.quixada.usoroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ufc.quixada.usoroomdatabase.models.Pessoa;

public class itemAddAdapter extends RecyclerView.Adapter<itemAddAdapter.ViewHolder> {
    private int itemLayout;
    private List<Pessoa> pessoas;

    public itemAddAdapter(int layoutid, List<Pessoa> pessoas) {
        this.itemLayout = layoutid;
        this.pessoas = pessoas;
    }

    @Override
    public int getItemCount() {
        return pessoas == null ? 0 : pessoas.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pessoa pessoa = pessoas.get(position);
        holder.itemAddNome.setText(pessoa.nome);
        holder.itemAddCurso.setText(pessoa.curso);
        holder.itemAddIdade.setText(String.valueOf(pessoa.idade));
    }

    public void updatePessoas(List<Pessoa> novasPessoas) {
        this.pessoas = novasPessoas;
        notifyDataSetChanged();
    }

    public Pessoa getPessoaAtPosition(int position) {
        return pessoas.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemAddNome;
        public TextView itemAddCurso;
        public TextView itemAddIdade;

        public ViewHolder(View itemAddView) {
            super(itemAddView);
            itemAddView.setOnClickListener(this);
            itemAddNome = itemAddView.findViewById(R.id.tv_nome);
            itemAddCurso = itemAddView.findViewById(R.id.tv_curso);
            itemAddIdade = itemAddView.findViewById(R.id.tv_idade);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item clicado", Toast.LENGTH_SHORT).show();
        }
    }
}