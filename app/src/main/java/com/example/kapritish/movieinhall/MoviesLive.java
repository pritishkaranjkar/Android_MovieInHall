package com.example.kapritish.movieinhall;

/**
 * Created by kapritish on 10/15/16.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melissahuang on 7/18/16.
 */
public class MoviesLive {

    @SerializedName("results")
    List<Movie> movieList;

    // public constructor is necessary for collections
    public MoviesLive() {
        movieList = new ArrayList<Movie>();
    }

    public static MoviesLive parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        MoviesLive MoviesLive = gson.fromJson(response, MoviesLive.class);
        return MoviesLive;
    }
}