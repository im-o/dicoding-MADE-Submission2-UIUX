package com.stimednp.aplikasimoviecataloguesub2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        TextView tvMovieTitle = findViewById(R.id.tv_movie_detail_title);
        TextView tvMovieDesc = findViewById(R.id.tv_movie_desc_detail);
        TextView tvMovieRelease = findViewById(R.id.tv_movie_detail_release);
        TextView tvMovieRating = findViewById(R.id.tv_movie_rating_detail);
        TextView tvMovieGenre = findViewById(R.id.tv_movie_detail_genres);
        ImageView imgViewFromUrl = findViewById(R.id.img_movie_photo_detail);
        ImageView imgViewBg = findViewById(R.id.img_baground_movies);

        try {
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            if (movie != null) {
                String movieTitle = movie.getMovieTitle();
                String movieDesc = movie.getMovieDescription();
                String movieRelease = movie.getMovieRelease();
                String movieRating = movie.getMovieRating();
                String movieGenre = movie.getMovieGenre();
                String movieUrlPhoto = movie.getMovieUrlPhoto();
                mToolbar = findViewById(R.id.toolbar_details);
                setSupportActionBar(mToolbar);

                //call methods
                setActionBarToolbar();

                //get year exp : (2018)
                String releaseYear = "";
                if (movieRelease.length() >= 4) {
                    releaseYear = movieRelease.substring(movieRelease.length() - 4);
                } else {
                    releaseYear = "****";
                }

                tvMovieTitle.setText(String.format(movieTitle + " (%s)", releaseYear));
                tvMovieDesc.setText(movieDesc);
                tvMovieRelease.setText(movieRelease);
                tvMovieGenre.setText(movieGenre);
                tvMovieRating.setText(movieRating);
                Glide.with(getApplicationContext())
                        .load(movieUrlPhoto)
                        .animate(R.anim.fade_scale_animation)
                        .error(R.color.colorPrimary)
                        .centerCrop()
                        .into(imgViewFromUrl);

                Glide.with(getApplicationContext())
                        .load(movieUrlPhoto)
                        .centerCrop()
                        .into(imgViewBg);
            }
        } catch (Exception e) {
            Log.w("MSG-CODE", "ERROR : " + e);
        }
    }

    private void setActionBarToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
