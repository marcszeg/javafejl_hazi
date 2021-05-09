package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.entity.MovieEntity;
import com.epam.training.ticketservice.domain.Movie;

public class MovieMapperImpl implements  MovieMapper{

    @Override
    public Movie fromMapToMovie(MovieEntity movieEntity) {
        return new Movie(movieEntity.getTitle(), movieEntity.getGenre(), movieEntity.getLength());
    }

    @Override
    public MovieEntity fromMapToEntityMovie(Movie movie) {
        return new MovieEntity(movie.getTitle(), movie.getGenre(), movie.getLength());
    }
}
