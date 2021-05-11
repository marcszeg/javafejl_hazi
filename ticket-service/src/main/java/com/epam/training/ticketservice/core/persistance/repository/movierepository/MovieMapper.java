package com.epam.training.ticketservice.core.persistance.repository.movierepository;

import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.Movie;

public interface MovieMapper {
    Movie fromMapToMovie(MovieEntity movieEntity);

    MovieEntity fromMapToMovieEntity(Movie movie);
}
