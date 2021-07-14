package com.example.demomvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demomvvm.R;
import com.example.demomvvm.model.Movie;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieListAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false);

        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieListViewHolder holder, int position) {
        holder.movieName.setText(this.movieList.get(position).getMovieName());
        Glide.with(context)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.fitCenterTransform())
                .into(holder.movieImg);
    }

    @Override
    public int getItemCount() {
        if (this.movieList != null){
            return this.movieList.size();
        }
        return 0;
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;
        ImageView movieImg;

        public MovieListViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.tv_movieName);
            movieImg = (ImageView) itemView.findViewById(R.id.img_movie);
        }
    }
}
