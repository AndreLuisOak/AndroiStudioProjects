package com.example.exemplos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapterModel {
    package com.example.mycardview;

    public class model {
        String title;
        String description;
        int image;

        public model(String title, String description, int image) {
            this.title = title;
            this.description = description;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    package com.example.mycardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class cardAdapter extends RecyclerView.Adapter<cardAdapter.ViewHolder> {

        private List<model> modelList;

        public cardAdapter(List<model>modelList){
            this.modelList = modelList;
        }

        @NonNull
        @Override
        public cardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutview,parent,false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull cardAdapter.ViewHolder holder, int position) {
            model model = modelList.get(position);
            holder.text_title.setText(model.getTitle());
            holder.text_description.setText(model.getDescription());
            holder.card_layout.setBackgroundResource(model.getImage());
        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView text_title, text_description;
            ConstraintLayout card_layout;

            public ViewHolder(View itemView){
                super(itemView);

                text_title = itemView.findViewById(R.id.text_title);
                text_description = itemView.findViewById(R.id.text_description);
                card_layout = itemView.findViewById(R.id.card_layout);

                text_title.setOnClickListener(this);
                text_description.setOnClickListener(this);
                card_layout.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Você clicou no item: " + text_title.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
