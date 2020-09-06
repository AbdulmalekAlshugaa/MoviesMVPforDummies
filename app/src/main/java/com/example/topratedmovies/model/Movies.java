
package com.example.topratedmovies.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.crypto.AEADBadTagException;

public class Movies {
    private ArrayList<Movies> ListofMovies = new ArrayList<>();
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("release_date")
    @Expose
    private String release_date;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    public Movies(String title, String release_date, String poster_path) {
        this.title = title;
        this.release_date = release_date;
        this.poster_path = poster_path;
    }

    public Movies() {
    }

    public ArrayList<Movies> getListofMovies() {
        return ListofMovies;
    }

    public void setListofMovies(ArrayList<Movies> listofMovies) {
        ListofMovies = listofMovies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
