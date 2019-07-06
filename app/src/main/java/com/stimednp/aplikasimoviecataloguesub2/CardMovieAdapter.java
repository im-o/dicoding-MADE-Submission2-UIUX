package com.stimednp.aplikasimoviecataloguesub2;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by rivaldy on 7/4/2019.
 */

public class CardMovieAdapter extends RecyclerView.Adapter<CardMovieAdapter.CardMovieViewHolder> {
    private ArrayList<Movie> listMovies;
    private Context context;

    public ArrayList<Movie> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }

    public CardMovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardMovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_list_movie, viewGroup, false);
        return new CardMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardMovieViewHolder cardMovieViewHolder, int position) {
        cardMovieViewHolder.cardViewImg.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
        cardMovieViewHolder.cardViewDesc.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_from_end));
        cardMovieViewHolder.cardViewRating.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));

        Movie movie = getListMovies().get(position);
        Glide.with(context)
                .load(movie.getMovieUrlPhoto())
                .centerCrop()
                .placeholder(R.color.colorWhite)
                .error(R.color.colorPrimary)
                .into(cardMovieViewHolder.imgViewFromUrl);
        cardMovieViewHolder.tvMovieTitle.setText(movie.getMovieTitle());
        cardMovieViewHolder.tvMovieDesc.setText(movie.getMovieDescription());
        cardMovieViewHolder.tvMovieRelease.setText(movie.getMovieRelease());
        cardMovieViewHolder.tvMovieRating.setText(movie.getMovieRating());

        cardMovieViewHolder.cardViewDesc.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context, DetailsMovieActivity.class);
                intent.putExtra(DetailsMovieActivity.EXTRA_MOVIE, getListMovies().get(position));
                context.startActivity(intent);
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    class CardMovieViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewImg, cardViewDesc, cardViewRating;
        ImageView imgViewFromUrl;
        private TextView tvMovieTitle, tvMovieDesc, tvMovieRelease, tvMovieRating;

        CardMovieViewHolder(@NonNull View view) {
            super(view);
            tvMovieTitle = view.findViewById(R.id.tv_movie_title);
            tvMovieDesc = view.findViewById(R.id.tv_movie_desc);
            tvMovieRelease = view.findViewById(R.id.tv_movie_release);
            tvMovieRating = view.findViewById(R.id.tv_movie_rating);
            imgViewFromUrl = view.findViewById(R.id.img_movie_photo);
            cardViewImg = view.findViewById(R.id.card_img);
            cardViewDesc = view.findViewById(R.id.card_view_desc);
            cardViewRating = view.findViewById(R.id.card_view_rating);
        }
    }

//    private void addItem(){
//        listMovies = new ArrayList<>();
//        for (int i = 0; i< dataName.length; i++){
//            Movie movie = new Movie();
//            movie.setMovieTitle(dataName[0]);
//            movie.setMovieDescription(dataDesc[1]);
//            movie.setMovieRelease(dataRelease[2]);
//            movie.setMovieGenre(dataGenre[3]);
//            movie.setMovieRating(dataRating[4]);
//            movie.setMovieUrlPhoto(dataUrlPhoto[5]);
//            listMovies.add(movie);
//        }
//    }
}
