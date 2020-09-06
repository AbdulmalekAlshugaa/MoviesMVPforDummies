package com.example.topratedmovies.moviesImp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.topratedmovies.model.Movies;
import com.example.topratedmovies.presnter.Presenter;
import com.example.topratedmovies.view.ViewMovies;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class MoviesImp  implements Presenter, ViewMovies {
    private static final String TAG = "MoviesImp";
    private ViewMovies viewMovies;

    public MoviesImp(ViewMovies viewMovies) {
        this.viewMovies = viewMovies;
    }

    @Override
    public void OnSuccessPrs(Activity activity) throws JSONException {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            viewMovies.OnError(ex.getMessage());

        }

        JSONArray array = new JSONArray(json);
        viewMovies.OnsuccessMessage(array);






    

    }

    @Override
    public void OnSuccess(Movies movies) {

    }

    @Override
    public void OnsuccessMessage(JSONArray OnSuccess) {

    }

    @Override
    public void OnError(String ErrorMessage) {

    }
}
