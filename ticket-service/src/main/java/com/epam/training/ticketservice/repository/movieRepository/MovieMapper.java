package com.epam.training.ticketservice.repository.movieRepository;

import com.epam.training.ticketservice.datab.movieDatab.MovieEntity;
import com.epam.training.ticketservice.core.Movie;

public interface MovieMapper {
    Movie fromMapToMovie(MovieEntity movieEntity);

    MovieEntity fromMapToMovieEntity(Movie movie);
}
