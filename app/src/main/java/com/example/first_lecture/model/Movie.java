package com.example.first_lecture.model;

import android.media.Image;
import android.widget.ImageView;

public class Movie {

    private String genre;
    private int year;
    private String title;

    public Movie(String genre, int year, String title) {
        this.genre = genre;
        this.year = year;
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}