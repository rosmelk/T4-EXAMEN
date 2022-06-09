package com.example.t4examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t4examen.entities.Anime;
import com.example.t4examen.factories.RetroFactory;
import com.example.t4examen.services.AnimeServices;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VerDetalles extends AppCompatActivity {

    EditText eNombre;
    EditText eDescripcion;
    EditText eImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles);

        String animeJSON = getIntent().getStringExtra("DATOS");
        Anime anime = new Gson().fromJson(animeJSON, Anime.class);
        Button btnGuardar = findViewById(R.id.btnGuardarOk);

        eNombre = findViewById(R.id.eNombre);
        eDescripcion = findViewById(R.id.eDescripcion);
        eImagen = findViewById(R.id.eImagen);


        eNombre.setText(anime.nombre);
        eDescripcion.setText(anime.descripcion);
        eImagen.setText(anime.imagen);

       btnGuardar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Retrofit retrofit = RetroFactory.build();
               AnimeServices service = retrofit.create(AnimeServices.class);

               Anime anime = new Anime();
               anime.nombre = String.valueOf(eNombre.getText());
               anime.descripcion = String.valueOf(eDescripcion.getText());
               anime.imagen = String.valueOf(eImagen.getText());

               Call<Anime> call = service.editar(anime.id, anime);

           }
       });



    }
}





