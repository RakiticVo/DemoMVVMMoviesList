package com.example.demomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.demomvvm.adapter.MovieListAdapter;
import com.example.demomvvm.model.Movie;
import com.example.demomvvm.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tv_failed;
    private MovieListAdapter adapter;
    private List<Movie> movieList;
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_movie);
        tv_failed = findViewById(R.id.tv_failed);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MovieListAdapter(this, movieList);
        recyclerView.setAdapter(adapter);

        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        movieListViewModel.getMoviesList().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies != null){
                    movieList = movies;
                    Log.e("TAG", "onChanged: " + movieList.get(0));
                    adapter.setMovieList(movies);
                    tv_failed.setVisibility(View.GONE);
                }else {
                    tv_failed.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}