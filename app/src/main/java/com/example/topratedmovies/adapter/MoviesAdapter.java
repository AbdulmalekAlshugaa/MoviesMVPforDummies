package com.example.topratedmovies.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.topratedmovies.R;
import com.example.topratedmovies.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context mCtxt;
    private ArrayList<Movies> ListData;
    private static final String TAG = "MoviesAdapter";

    public MoviesAdapter(Context mCtxt, ArrayList<Movies> listData) {
        this.mCtxt = mCtxt;
        ListData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.MovieTitle.setText(ListData.get(position).getTitle());
        holder.ReleaseYear.setText(ListData.get(position).getRelease_date());
        Picasso.with(mCtxt).load(ListData.get(position).getPoster_path()).into(holder.PosterMovie);
        Log.d(TAG, "onBindViewHolder: "+ListData.get(position).getPoster_path());

    }

    @Override
    public int getItemCount() {
        return ListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView MovieTitle,ReleaseYear;
        private ImageView PosterMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            MovieTitle = itemView.findViewById(R.id.MoviesTitle);
            ReleaseYear = itemView.findViewById(R.id.releaseYear);
            PosterMovie = itemView.findViewById(R.id.iv_movie_poster);


        }
    }

}
