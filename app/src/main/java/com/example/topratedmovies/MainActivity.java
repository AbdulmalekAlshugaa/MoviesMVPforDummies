package com.example.topratedmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.topratedmovies.model.Movies;
import com.example.topratedmovies.moviesImp.MoviesImp;
import com.example.topratedmovies.view.ViewMovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements ViewMovies {
    
    private MoviesImp mMoviesImp;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MoviesImp moviesImp = new MoviesImp(this);
        try {
            moviesImp.OnSuccessPrs(MainActivity.this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: ");
        
    }

    @Override
    public void OnSuccess(Movies movies) {
        
    }

    @Override
    public void OnsuccessMessage(JSONArray OnSuccess) throws JSONException {

        for(int i=0; i < OnSuccess.length(); i++) {
            JSONObject object = OnSuccess.getJSONObject(i);
            Movies movies = new Movies();
            movies.setTitle(object.getString("title"));
            movies.setRelease_date(object.getString("release_date"));
            movies.setPoster_path(object.getString("poster_path"));

            Log.d(TAG, "OnsuccessMessage: "+object.getString("poster_path"));

        }
    }

    @Override
    public void OnError(String ErrorMessage) {
        Log.d(TAG, "OnError: "+ErrorMessage);

    }
}
