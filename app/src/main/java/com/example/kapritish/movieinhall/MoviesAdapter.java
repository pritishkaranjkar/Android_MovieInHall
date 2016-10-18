package com.example.kapritish.movieinhall;

/**
 * Created by kapritish on 10/15/16.
 */
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by melissahuang on 7/20/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    // URL constants
    final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p";
    final String POSTER_WIDTH = "/w154";
    final String BACKDROP_WIDTH = "/w780";
    private ArrayList<Movie> mMovies = new ArrayList<Movie>();

    // View Lookup cache
    private static class ViewModel {
        ImageView movieImageView;
        TextView movieTitle;
        TextView movieOverview;
        ImageView movieImagePoster;
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }


    @Override
    public int getItemViewType(int position) {
//        Movie movie = mMovies.get(position);
        Movie movie = getItem(position);
        if (movie.vote_average >= 5D) {
            //return getItem(position).rows.ordinal();
            return movie.getRows().POPULAR.ordinal();
        } else {
            return movie.getRows().REGULAR.ordinal();
        }

    }

    @Override
    public int getViewTypeCount() {
        return Movie.RowType.values().length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the movie for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewModel viewModel; // view lookup cache stored in tag

        int type = getItemViewType(position);
        //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        if (type == Movie.RowType.POPULAR.ordinal()) {
            if (convertView == null) {
                viewModel = new ViewModel();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.poster, null, false);
                viewModel.movieImagePoster = (ImageView) convertView.findViewById(R.id.movieImagePoster);
                //convertView = getInflatedLayoutForType(type);
                convertView.setTag(viewModel);
            } else {
                // View is being recycled, inflate with view model
                viewModel = (ViewModel) convertView.getTag();
            }

            int orientation = getContext().getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                String url = IMAGE_BASE_URL + POSTER_WIDTH + movie.poster_path;

                Picasso.with(getContext()).load(url).fit().centerInside()
                       .placeholder(R.drawable.movie_night).transform(new RoundedCornersTransformation(30, 30))
                    .into(viewModel.movieImagePoster);

            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                String url = IMAGE_BASE_URL + BACKDROP_WIDTH + movie.backdrop_path;

                Picasso.with(getContext()).load(url).fit().centerInside()
                        .placeholder(R.drawable.movie_night).transform(new RoundedCornersTransformation(10, 10))
                        .into(viewModel.movieImagePoster);
            }
            return convertView;
        } else if (type == Movie.RowType.REGULAR.ordinal()) {
            // Populate the data into the template view using the data object
            if (convertView == null) {
                viewModel = new ViewModel();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);

                viewModel.movieTitle = (TextView) convertView.findViewById(R.id.movieTitle);
                viewModel.movieOverview = (TextView) convertView.findViewById(R.id.movieOverview);
                viewModel.movieImageView = (ImageView) convertView.findViewById(R.id.movieImageView);

                convertView.setTag(viewModel);

            } else {
                // View is being recycled, inflate with view model
                viewModel = (ViewModel) convertView.getTag();
            }

        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            String url = IMAGE_BASE_URL + POSTER_WIDTH + movie.poster_path;
            Picasso.with(getContext()).load(url).fit().centerInside()
                    .placeholder(R.drawable.movie_night).transform(new RoundedCornersTransformation(30, 30))
                    .into(viewModel.movieImageView);


        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String url = IMAGE_BASE_URL + BACKDROP_WIDTH + movie.backdrop_path;

            Picasso.with(getContext()).load(url).fit().centerInside()
                    .placeholder(R.drawable.movie_night).transform(new RoundedCornersTransformation(10, 10))
                    .into(viewModel.movieImageView);
        }

        viewModel.movieTitle.setText(movie.title);
        viewModel.movieOverview.setText(movie.overview);


        return convertView;
    }
        else
            return null;

    }


}
