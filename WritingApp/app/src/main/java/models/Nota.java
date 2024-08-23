package models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nota")
public class Nota {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "conteudo")
    public String conteudo;

    public Nota(String conteudo){
        this.conteudo = conteudo;
    }

    @NonNull
    @Override
    public String toString(){
        return uid + " | " + conteudo;
    }
}
