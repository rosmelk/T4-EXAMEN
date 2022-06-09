package com.example.t4examen.adapaters;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.t4examen.R;
import com.example.t4examen.VerDetalles;
import com.example.t4examen.entities.Anime;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import java.util.List;
public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolderAnime>   {


    List<Anime> anime;
    public AnimeAdapter(List<Anime> anime) {
        this.anime = anime;
    }


    @NonNull
    @Override
    public AnimeAdapter.ViewHolderAnime onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_layout,parent,false);

        return new ViewHolderAnime(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAnime vh, int position) {
        View itemView =vh.itemView;
        Anime animes = anime.get(position);
        ImageView tvImagen = itemView.findViewById(R.id.tvImagen);
        TextView txtNombre = itemView.findViewById(R.id.tvNombre);
        TextView txtDescrip= itemView.findViewById(R.id.tvDescrip);

        Picasso.get().load(animes.imagen).into(tvImagen);
        txtNombre.setText(animes.nombre);
        txtDescrip.setText(animes.descripcion);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), VerDetalles.class);
                String animeJSON = new Gson().toJson(animes);
                intent.putExtra("DATOS",animeJSON );
                itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return anime.size();
    }


    public class ViewHolderAnime extends RecyclerView.ViewHolder {
        public ViewHolderAnime(@NonNull View itemView) {
            super(itemView);
        }


    }
}
