package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dao.LivroDao;
import models.Livro;


@Database(entities = {Livro.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract LivroDao livroDao();
}