package com.example.t4examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.t4examen.database.AppDataBase;
import com.example.t4examen.entities.Anime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Anime> anime = new ArrayList<>();
    AppDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDataBase.getDataBase(getApplicationContext());

        Button btnCrear = findViewById(R.id.btnCRear);
        Button btnSicronizar = findViewById(R.id.btnSicronizar);
        Button btnMostrar = findViewById(R.id.btnM);

        //mostrar
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MostrarActividad.class);
                startActivity(intent);

            }
        });


        //sicronizar
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearAnime.class);
                startActivity(intent);

            }
        });

     /*           Retrofit retrofit = RetroFactory.build();
                AnimeServices service = retrofit.create(AnimeServices.class);
                Call<List<Anime2>> call = service.getAnime();

                call.enqueue(new Callback<List<Anime2>>() {
                    @Override
                    public void onResponse(Call<List<Anime2>> call, Response<List<Anime2>> response) {
                        if(!response.isSuccessful()) {
                            Log.e("APP_VJ20202", "Error de aplicación");
                        }
                        else {
                            Log.i("APP_VJ20202", "Respuesta Correcta");
                            anime = response.body();
                            saveIndata(anime);

                            AnimeAdapter adapters = new AnimeAdapter(anime2);
                            RecyclerView rv = findViewById(R.id.rvLista);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            rv.setHasFixedSize(true);
                            rv.setAdapter(adapters);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Anime2>> call, Throwable t) {
                        Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
                    }
                });*/



        //crear
        btnSicronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SicronizarActividad.class);
                startActivity(intent);

            }
        });
    }


/*    private void saveIndata(List<Anime>  anime){

        AnimeDAO dao = db.animeDAO();
        for( Anime anime1: anime) {
            dao.create(anime1);
        }
    }*/


}