package com.example.demomvvm.network;

import com.example.demomvvm.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    // url: http://192.168.1.37/movies/getdata.php
    @GET("getdata.php")
    Call<List<Movie>> getMovieList();

}
