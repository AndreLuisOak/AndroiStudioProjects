package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import models.Personagem;

@Dao
public interface PersonagemDao {
    @Insert
    void insertAll(Personagem... personagens);

    @Update
    void updatePersonagem(Personagem personagem);

    @Delete
    void delete(Personagem personagem);

    @Query("SELECT * FROM personagem")
    List<Personagem> getAllPersonagens();
}
