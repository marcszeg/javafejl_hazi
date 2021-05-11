package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.datab.entity.MovieEntity;
import com.epam.training.ticketservice.core.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements  MovieMapper {

    public MovieMapperImpl() {
    }

    @Override
    public Movie fromMapToMovie(MovieEntity movieEntity) {
        return new Movie(movieEntity.getTitle(), movieEntity.getGenre(), movieEntity.getLength());
    }

    public MovieEntity fromMapToMovieEntity(Movie movie) {
        return new MovieEntity(movie.getTitle(), movie.getGenre(), movie.getLength());
    }
}
