package com.stimednp.aplikasimoviecataloguesub2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabTvShowFragment extends Fragment {
    private String[] dataName;
    private String[] dataDesc;
    private String[] dataRelease;
    private String[] dataGenre;
    private String[] dataRating;
    private String[] dataUrlPhoto;
    private RecyclerView recyclerView;
    private ArrayList<Movie> list = new ArrayList<>();

    public TabTvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataName = view.getResources().getStringArray(R.array.data_tvshow_title);
        dataDesc = view.getResources().getStringArray(R.array.data_tvshow_desc);
        dataRelease = view.getResources().getStringArray(R.array.data_tvshow_release);
        dataGenre = view.getResources().getStringArray(R.array.data_movie_genre);
        dataRating = view.getResources().getStringArray(R.array.data_tvshow_rating);
        dataUrlPhoto = view.getResources().getStringArray(R.array.data_tvshow_url_photo);

        //call method
        allDataMovies();

        recyclerView = view.findViewById(R.id.rv_tab_tvshow);
        recyclerView.setHasFixedSize(true);
        showRecyclerList();
    }

    private void allDataMovies() {
        list = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setMovieTitle(dataName[i]);
            movie.setMovieDescription(dataDesc[i]);
            movie.setMovieRelease(dataRelease[i]);
            movie.setMovieGenre(dataGenre[i]);
            movie.setMovieRating(dataRating[i]);
            movie.setMovieUrlPhoto(dataUrlPhoto[i]);
            list.add(movie);
        }
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CardMovieAdapter cardMovieAdapter = new CardMovieAdapter(getContext());
        cardMovieAdapter.setListMovies(list);
        recyclerView.setAdapter(cardMovieAdapter);
    }
}
