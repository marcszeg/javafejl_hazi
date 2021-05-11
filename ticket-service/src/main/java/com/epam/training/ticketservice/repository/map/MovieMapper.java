package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.datab.entity.MovieEntity;
import com.epam.training.ticketservice.core.Movie;

public interface MovieMapper {
    Movie fromMapToMovie(MovieEntity movieEntity);

    MovieEntity fromMapToMovieEntity(Movie movie);
}
