package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.entity.MovieEntity;
import com.epam.training.ticketservice.domain.Movie;

public interface MovieMapper {
    Movie fromMapToMovie(MovieEntity movieEntity);

    MovieEntity fromMapToMovieEntity(Movie movie);
}
