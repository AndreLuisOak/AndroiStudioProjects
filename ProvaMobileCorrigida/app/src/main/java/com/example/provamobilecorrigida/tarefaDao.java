package com.example.provamobilecorrigida;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface tarefaDao {

    @Insert
    void insert(Tarefa tarefa);

    @Query("SELECT * FROM tarefas")
    List<Tarefa> getAllTasks();
}

