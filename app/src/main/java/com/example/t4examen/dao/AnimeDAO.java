package com.example.t4examen.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.t4examen.entities.Anime;

import java.util.List;
@Dao
public interface AnimeDAO {

    @Query("SELECT * FROM  animes")
    List<Anime> getAll();

    @Insert
    void create(Anime contact);


}
