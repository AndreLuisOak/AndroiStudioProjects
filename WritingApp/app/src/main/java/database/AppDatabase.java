package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;

import dao.LivroDao;
import models.Livro;


@Database(entities = {Livro.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase instance;
    public abstract LivroDao livroDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "livros")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}