package com.example.t4examen.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.t4examen.dao.AnimeDAO;
import com.example.t4examen.entities.Anime;

@Database(entities = {Anime.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AnimeDAO animeDAO();

    public static AppDataBase getDataBase(Context context){
        return Room.databaseBuilder(context, AppDataBase.class, "com.example.t4examen.database").allowMainThreadQueries()
                .build();
    }


}