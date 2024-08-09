package com.example.provamobile;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insertAll(Item... itens);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM lista")
    List<Item> getAllItens();
}
