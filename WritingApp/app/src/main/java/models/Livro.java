package models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "livro")
public class Livro {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "autor")
    public String autor;

    @ColumnInfo(name = "sinopse")
    public String sinopse;

    public Livro(String titulo, String autor, String sinopse){
        this.titulo = titulo;
        this.autor = autor;
        this.sinopse = sinopse;
    }

    @NonNull
    @Override
    public String toString() {
        return uid + " | " + titulo + " | " + autor + " | " + sinopse;
    }
}