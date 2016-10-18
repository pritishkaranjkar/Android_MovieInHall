package com.example.kapritish.movieinhall;

import java.io.Serializable;

/**
 * Created by kapritish on 10/15/16.
 */
public class Movie implements Serializable {
    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public RowType getRows() {
        return rows;
    }

    public void setRows(RowType rows) {
        this.rows = rows;
    }

    boolean adult;
    String backdrop_path;
    int id;
    String title;
    String overview;
    String poster_path;
    Double vote_average;

    enum RowType {
        REGULAR,
        POPULAR
    }

    public RowType rows;

    Movie(boolean adult, String backdrop_path, int id, String title, String overview, String poster_path, Double vote_average) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
    }


}
