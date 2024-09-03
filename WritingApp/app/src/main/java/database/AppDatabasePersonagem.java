package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dao.PersonagemDao;
import models.Personagem;

@Database(entities = {Personagem.class}, version = 1)
public abstract class AppDatabasePersonagem extends RoomDatabase {
    private static AppDatabasePersonagem instance;

    public abstract PersonagemDao personagemDao();

    public static synchronized AppDatabasePersonagem getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabasePersonagem.class, "personagens")
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
