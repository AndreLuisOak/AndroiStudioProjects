package com.example.provamobile;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lista")
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "titulo")
    public String titulo;
    @ColumnInfo(name = "descricao")
    public String descricao;

    public Item(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    @NonNull
    @Override
    public String toString(){
        String nomeRetorno = this.uid + " | " + this.titulo + " | " + this.descricao;
        return nomeRetorno ;
    }
}
