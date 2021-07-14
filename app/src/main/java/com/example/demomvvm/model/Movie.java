package com.example.demomvvm.model;

public class Movie {
    private int id;
    private String image;
    private String movieName;

    public Movie(int id, String movieName, String image) {
        this.id = id;
        this.movieName = movieName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
