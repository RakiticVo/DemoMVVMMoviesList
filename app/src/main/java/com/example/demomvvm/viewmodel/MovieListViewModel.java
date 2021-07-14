package com.example.demomvvm.viewmodel;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demomvvm.model.Movie;
import com.example.demomvvm.network.APIService;
import com.example.demomvvm.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> moviesList = null;

    public LiveData<List<Movie>> getMoviesList() {
        if (moviesList == null){
            moviesList = new MutableLiveData<List<Movie>>();
        }
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        apiService.getMovieList().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                moviesList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
            }
        });
        return moviesList;
    }
}
