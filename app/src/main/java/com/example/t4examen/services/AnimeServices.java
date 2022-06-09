package com.example.t4examen.services;

import com.example.t4examen.entities.Anime;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AnimeServices {


    @GET("anime")
    Call<List<Anime>> getAnime();

    //Guardar
    @POST("anime")
    Call<Anime> create(@Body Anime anime);

    //editar
    @PUT("anime/{id}")
    Call<Anime> editar(@Path("id") int id  , @Body Anime anime);

}
