package models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "personagem")
public class Personagem {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nome")
    public String nome;

    @ColumnInfo(name = "idade")
    public int idade;

    @ColumnInfo(name = "genero")
    public String genero;

    @ColumnInfo(name = "aparencia")
    public String aparencia;

    @ColumnInfo(name = "personalidade")
    public String personalidade;

    public Personagem(String nome, int idade, String genero, String aparencia, String personalidade){
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.aparencia = aparencia;
        this.personalidade = personalidade;
    }

    @NonNull
    @Override
    public String toString(){
        return uid + " | " + nome + " | " + idade + " | " + genero + " | " + aparencia  + " | " + personalidade;
    }

}
