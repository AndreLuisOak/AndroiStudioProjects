package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import models.Livro;

@Dao
public interface LivroDao {
    @Insert
    void insertAll(Livro... livros);

    @Delete
    void delete(Livro livro);

    @Query("SELECT * FROM livro")
    List<Livro> getAllLivros();
}