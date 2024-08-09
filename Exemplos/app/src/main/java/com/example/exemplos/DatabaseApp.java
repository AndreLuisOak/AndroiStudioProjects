package com.example.exemplos;

import androidx.annotation.NonNull;

import java.util.List;

public class DatabaseApp {
    package br.ufc.quixada.usoroomdatabase.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "pessoa")
    public class Pessoa {
        @PrimaryKey(autoGenerate = true)
        public int uid;
        @ColumnInfo(name = "nome")
        public String nome;
        @ColumnInfo(name = "curso")
        public String curso;
        @ColumnInfo(name = "idade")
        public int idade;


        public Pessoa(String nome, String curso, int idade){
            this.nome = nome;
            this.curso = curso;
            this.idade = idade;
        }

        @NonNull
        @Override
        public String toString() {
            String nomeRetorno = this.uid + " | " + this.nome + " | " + this.curso + " | " + this.idade;
            return nomeRetorno ;
        }
    }

    package br.ufc.quixada.usoroomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.ufc.quixada.usoroomdatabase.dao.PessoaDao;
import br.ufc.quixada.usoroomdatabase.models.Pessoa;

    @Database(entities = {Pessoa.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {

        public abstract PessoaDao pessoaDao();
    }

    //interface
    package br.ufc.quixada.usoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.ufc.quixada.usoroomdatabase.models.Pessoa;

    @Dao
    public interface PessoaDao {
        @Insert
        void insertAll(Pessoa... pessoas);

        @Delete
        void delete(Pessoa pessoa);

        @Query("SELECT * FROM pessoa")
        List<Pessoa> getAllPessoas();

    }
}
