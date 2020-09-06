package com.example.topratedmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.topratedmovies.adapter.MoviesAdapter;
import com.example.topratedmovies.model.Movies;
import com.example.topratedmovies.moviesImp.MoviesImp;
import com.example.topratedmovies.view.ViewMovies;
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewMovies {
    
    private MoviesImp mMoviesImp;
    private static final String TAG = "MainActivity";
    private ArrayList<Movies> mMoviesList = new ArrayList<>(); // mNote
    private MoviesAdapter mListCurrentDateMoviesAdapter; // Adapter
    private RecyclerView mListDataView;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListDataView = findViewById(R.id.rMovies);
        MoviesImp moviesImp = new MoviesImp(this);
        try {
            moviesImp.OnSuccessPrs(MainActivity.this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: ");

        mProgressBar = findViewById(R.id.googlePross);

        mProgressBar.setIndeterminateDrawable(new ChromeFloatingCirclesDrawable.Builder(this)
                .build());
        mProgressBar.setVisibility(View.VISIBLE);
        RecyclerViewMethods();
        
    }


    private void RecyclerViewMethods() {
        mListDataView.setLayoutManager(new GridLayoutManager(this, 2));

        mListDataView.setHasFixedSize(true);
        mListCurrentDateMoviesAdapter = new MoviesAdapter(this, mMoviesList);
        mListDataView.setAdapter(mListCurrentDateMoviesAdapter);
        mListDataView.invalidate();

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

            mMoviesList.add(movies);

        }
       // mListCurrentDateMoviesAdapter.notifyDataSetChanged();
//        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void OnError(String ErrorMessage) {
        Log.d(TAG, "OnError: "+ErrorMessage);

    }
}
