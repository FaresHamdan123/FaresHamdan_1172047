package com.example.first_lecture.model;

public class MovieFactory {
    public IMovieDa getModel(){
        return new MovieDa();

    }
}
