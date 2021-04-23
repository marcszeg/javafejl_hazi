package com.epam.training.ticketservice.movie;

import com.epam.training.ticketservice.movie.entity.Movie;
import com.epam.training.ticketservice.movie.model.MovieDto;
import java.util.List;
import java.util.Optional;


public interface MovieService {
    List<MovieDto> getMovieList();

    Optional<MovieDto> getMovieByTitle(String movieTitle);

    void createMovie(MovieDto movie);

    void deleteMovie(Movie movie);
}
