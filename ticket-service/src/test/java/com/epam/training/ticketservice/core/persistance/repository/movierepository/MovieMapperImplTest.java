package com.epam.training.ticketservice.core.persistance.repository.movierepository;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperImplTest {

    private MovieMapperImpl movieMapperUnderTest = new MovieMapperImpl();

    private static final Movie MOVIE = new Movie("Movie", "genre", 90);
    private static final MovieEntity MOVIE_ENTITY = new MovieEntity("Movie", "genre", 90);


    @Test
    void testFromMovieEntityToMovieShouldReturnMovie() {
        //When
        Movie actual = movieMapperUnderTest.fromMovieEntityToMovie(MOVIE_ENTITY);

        //Then
        Assertions.assertEquals(MOVIE, actual);
    }

    @Test
    void testFromMovieToMovieEntityShouldReturnMovieEntity() {
        //When
        MovieEntity actual = movieMapperUnderTest.fromMovieToMovieEntity(MOVIE);

        //Then
        Assertions.assertEquals(MOVIE_ENTITY, actual);
    }
}