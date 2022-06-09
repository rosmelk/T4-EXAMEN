package com.example.t4examen;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.t4examen.adapaters.AnimeAdapter;
import com.example.t4examen.entities.Anime;
import com.example.t4examen.factories.RetroFactory;
import com.example.t4examen.services.AnimeServices;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MostrarActividad extends AppCompatActivity {

    List<Anime> anime = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_actividad);

        Retrofit retrofit = RetroFactory.build();
        AnimeServices service = retrofit.create(AnimeServices.class);
        Call<List<Anime>> call = service.getAnime();

         call.enqueue(new Callback<List<Anime>>() {
             @Override
             public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                  anime = response.body();
                 AnimeAdapter adapters = new AnimeAdapter(anime);
                 RecyclerView rv = findViewById(R.id.rvLista);
                 rv.setLayoutManager(new LinearLayoutManager(MostrarActividad.this));
                 rv.setHasFixedSize(true);
                 rv.setAdapter(adapters);
             }

             @Override
             public void onFailure(Call<List<Anime>> call, Throwable t) {
                 Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
             }
         });



    }
}