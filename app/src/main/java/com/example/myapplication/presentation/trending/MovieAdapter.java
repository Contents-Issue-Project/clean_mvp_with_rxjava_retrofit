package com.example.myapplication.presentation.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.trending.TrendingResource;
import com.example.myapplication.util.DataUnavailableException;
import com.example.myapplication.util.WrongRequestException;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
implements TrendingContract.View{
    private ArrayList<MovieItem> mMovies;

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        public TextView titleView;
        public TextView averageView;
        public MovieViewHolder(View itemView){
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.titleView);
            averageView = (TextView) itemView.findViewById(R.id.averageView);
        }

        public void setItem(MovieItem movie){
            titleView.setText(movie.title);
            averageView.setText(movie.average.toString());
        }
    }

    public MovieAdapter(){
        mMovies = new ArrayList<MovieItem>();
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(itemView);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setItem(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void addItem(MovieItem movie){
        mMovies.add(movie);
    }

    public void addItems(ArrayList<MovieItem> movies){
        mMovies.addAll(movies);
    }

    public MovieItem getItem(int position){
        return mMovies.get(position);
    }

    @Override
    public void setUpContent(TrendingResource trendingResource) {
        for (TrendingResource.Movie movie :
                trendingResource.data) {
            addItem(new MovieItem(movie.title, movie.average));
        }
        notifyDataSetChanged();
    }

    @Override
    public void handleWrongRequest(WrongRequestException exception) {
        System.out.println("Wrong Request");
    }

    @Override
    public void handleDataUnavailable(DataUnavailableException exception) {
        System.out.println("Data Unavailable");
    }
}
