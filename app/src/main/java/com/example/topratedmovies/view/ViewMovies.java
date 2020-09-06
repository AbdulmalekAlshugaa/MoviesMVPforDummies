package com.example.topratedmovies.view;

import com.example.topratedmovies.model.Movies;

import org.json.JSONArray;
import org.json.JSONException;

public interface ViewMovies {

    void OnSuccess(Movies movies);
    void  OnsuccessMessage (JSONArray OnSuccess) throws JSONException;

    void OnError (String ErrorMessage);

}
