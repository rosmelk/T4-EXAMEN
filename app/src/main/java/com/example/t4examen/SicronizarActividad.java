package com.example.t4examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.t4examen.dao.AnimeDAO;
import com.example.t4examen.database.AppDataBase;
import com.example.t4examen.entities.Anime;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SicronizarActividad extends AppCompatActivity {

    AppDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sicronizar_actividad);

        db = AppDataBase.getDataBase(getApplicationContext());
        AnimeDAO dao = db.animeDAO();
        List<Anime> animes = dao.getAll();
        Log.i("APP_VJ20202", new Gson().toJson(animes));

    }
}