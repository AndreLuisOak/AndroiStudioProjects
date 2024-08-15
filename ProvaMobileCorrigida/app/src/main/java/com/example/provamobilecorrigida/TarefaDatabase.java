package com.example.provamobilecorrigida;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class TarefaDatabase extends RoomDatabase {

    private static TarefaDatabase instance;

    public abstract tarefaDao tarefaDao();

    public static synchronized TarefaDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            TarefaDatabase.class, "tarefas")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
