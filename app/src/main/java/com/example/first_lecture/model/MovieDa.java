package com.example.first_lecture.model;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class MovieDa implements IMovieDa {
    String []allGenres= {"Comedy", "Drama","Crime","Romance","Adventure","Action","Animation"};


    @Override
    public ArrayList<Movie> getMoviesByTitle(ArrayList<Movie> list,String title) {
        ArrayList<Movie> movies =new ArrayList<Movie>();
        for (Movie movie:list){
            if(movie.getTitle().contains(title)){
                movies.add(movie);
            }
        }
        return movies;


    }

    @Override
    public ArrayList<Movie> getMoviesByYear(ArrayList<Movie> list, int year) {
        ArrayList<Movie> movies =new ArrayList<Movie>();
        for (Movie movie:list){
            if(movie.getYear()==year){
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public ArrayList<Movie> getMoviesByGenre(ArrayList<Movie> list, String genre) {
        ArrayList<Movie> movies =new ArrayList<Movie>();
        for (Movie movie:list){
            if(movie.getGenre().equals(genre)){
                movies.add(movie);
            }
        }
        return movies;
    }


    @Override
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie>movies=new ArrayList<>();
        movies.add(new Movie("Drama",2016,"PK"));
        movies.add(new Movie("Crime",2020,"La Casa De Papel"));
        movies.add(new Movie("Adventure",2014,"The Interstellar"));
        movies.add(new Movie("Action",2016,"GOT"));
        movies.add(new Movie("Animation",2015,"inside out"));
        movies.add(new Movie("Drama",2014,"The Imitation Game"));
        movies.add(new Movie("Action",2017,"Baby driver"));
        movies.add(new Movie("Drama",2015,"Room"));
        movies.add(new Movie("Action",2019,"Game night"));
        movies.add(new Movie("Crime",2009,"Sherlock Holmes"));
        movies.add(new Movie("Action",2011,"source code"));
        movies.add(new Movie("Comedy",2005,"Frinds"));
        movies.add(new Movie("Action",2001,"fast and furious 1"));
        movies.add(new Movie("Action",2003,"fast and furious 2"));
        movies.add(new Movie("Action",2006,"fast and furious 3"));
        movies.add(new Movie("Action",2009,"fast and furious 4"));
        movies.add(new Movie("Action",2011,"fast and furious 5"));
        movies.add(new Movie("Action",2013,"fast and furious 6"));
        movies.add(new Movie("Action",2015,"fast and furious 7"));
        movies.add(new Movie("Action",2017,"fast and furious 8"));
        movies.add(new Movie("Action",2019,"fast and furious 9"));





        return movies;

    }

    @Override
    public String[] getGenres() {
        return allGenres;
    }

    @Override
    public String[] getYears() {
        String years[]=new String[61];
        int val=1960;
        for (int i=0;i<=60;i++){
            years[i]=(val+"");
            val++;

        }
        return years;

    }





}