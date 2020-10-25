package com.example.first_lecture.model;

import java.util.ArrayList;

public interface IMovieDa {
    public ArrayList<Movie> getMoviesByTitle(ArrayList<Movie> list, String title);

    public ArrayList<Movie> getMoviesByYear(ArrayList<Movie> list, int year);

    public ArrayList<Movie> getMoviesByGenre(ArrayList<Movie> list, String genre);

    public ArrayList<Movie> getAllMovies();

    public String[] getGenres();

    public String[] getYears();
}


