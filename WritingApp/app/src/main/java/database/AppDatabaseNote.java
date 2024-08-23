package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dao.NotaDao;
import models.Nota;

@Database(entities = {Nota.class}, version = 1)
public abstract class AppDatabaseNote extends RoomDatabase {
    private static AppDatabaseNote instance;

    public abstract NotaDao notaDao();

    public static synchronized AppDatabaseNote getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabaseNote.class, "notas")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}