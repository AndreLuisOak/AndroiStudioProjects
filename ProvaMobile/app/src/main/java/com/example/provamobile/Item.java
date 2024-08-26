package com.example.provamobile;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lista")
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;
    public String descricao;

    public Item(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}