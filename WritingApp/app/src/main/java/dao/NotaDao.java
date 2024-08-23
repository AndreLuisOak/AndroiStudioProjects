package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import models.Nota;

@Dao
public interface NotaDao {
    @Insert
    void insertAll(Nota... notas);

    @Update
    void updateNota(Nota nota);

    @Delete
    void delete(Nota nota);

    @Query("SELECT * FROM nota")
    List<Nota> getAllNotas();
}
