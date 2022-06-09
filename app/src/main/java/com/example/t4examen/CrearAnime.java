package com.example.t4examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t4examen.entities.Anime;
import com.example.t4examen.factories.RetroFactory;
import com.example.t4examen.services.AnimeServices;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CrearAnime extends AppCompatActivity {

    EditText tNombre;
    EditText tDescripcion;
    EditText tImagen;

    Call<Anime> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_anime);
         tNombre = findViewById(R.id.tNombre);
        tDescripcion = findViewById(R.id.tDescripcion);
        tImagen = findViewById(R.id.tImagen);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetroFactory.build();
                AnimeServices service = retrofit.create(AnimeServices.class);
                Anime anime = new Anime();

                anime.nombre = String.valueOf(tNombre.getText());
                anime.descripcion= String.valueOf(tDescripcion.getText());
                anime.imagen= String.valueOf(tImagen.getText());


                String nombre = tNombre.getText().toString();
                String descripcion = tDescripcion.getText().toString();
                String imagen = tImagen.getText().toString();

                 if (nombre.length()==0){
                     Toast.makeText(getApplicationContext(), "Deebe escribir un nombre", Toast.LENGTH_LONG).show();

                 }

                if (descripcion.length()==0){
                    Toast.makeText(getApplicationContext(), "Debe escribir una descripcion", Toast.LENGTH_LONG).show();

                }
                if (imagen.length()==0){
                    Toast.makeText(getApplicationContext(), "Debe agregar una URL", Toast.LENGTH_LONG).show();

                }
                if (imagen.length()!=0 && anime.descripcion.length()!=0 && anime.nombre.length()!=0){
                    Toast.makeText(getApplicationContext(), "Se guardo los datos correctamente", Toast.LENGTH_LONG).show();
                    call = service.create(anime);

                    call.enqueue(new Callback<Anime>() {
                        @Override
                        public void onResponse(Call<Anime> call, Response<Anime> response) {
                            if (response.isSuccessful()){
                                Log.e("APP", new Gson().toJson(response.body()));

                            }
                        }

                        @Override
                        public void onFailure(Call<Anime> call, Throwable t) {

                        }
                    });
                }

            }
        });

    }


}