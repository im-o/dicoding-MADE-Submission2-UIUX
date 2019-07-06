package com.stimednp.aplikasimoviecataloguesub2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rivaldy on 7/4/2019.
 */

public class Movie implements Parcelable {
    private String movieTitle, movieDescription, movieRelease, movieGenre, movieRating, movieUrlPhoto;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(String movieRelease) {
        this.movieRelease = movieRelease;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieUrlPhoto() {
        return movieUrlPhoto;
    }

    public void setMovieUrlPhoto(String movieUrlPhoto) {
        this.movieUrlPhoto = movieUrlPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieDescription);
        dest.writeString(this.movieRelease);
        dest.writeString(this.movieGenre);
        dest.writeString(this.movieRating);
        dest.writeString(this.movieUrlPhoto);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.movieTitle = in.readString();
        this.movieDescription = in.readString();
        this.movieRelease = in.readString();
        this.movieGenre = in.readString();
        this.movieRating = in.readString();
        this.movieUrlPhoto = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
