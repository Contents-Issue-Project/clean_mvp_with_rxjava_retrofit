package com.example.myapplication.data.trending;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class TrendingResource {

    @SerializedName("results")
    public List<Movie> data = null;

    public class Movie {
        @SerializedName("original_title")
        public String title;
        @SerializedName("vote_average")
        public Double average;
        @SerializedName("overview")
        public String overview;
    }
}
