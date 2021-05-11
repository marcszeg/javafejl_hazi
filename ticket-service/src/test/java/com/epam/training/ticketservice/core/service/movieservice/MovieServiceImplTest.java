package com.epam.training.ticketservice.core.service.movieservice;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;


import java.util.List;

class MovieServiceImplTest {

    private MovieServiceImpl movieServiceUnderTest;
    private MovieRepository movieRepository;

    private static final String TITLE = "title";
    private static final String GENRE = "genre";
    private static final int LENGTH = 90;
    private static final Movie MOVIE = createMovie(TITLE, GENRE, LENGTH);
    private static final List<Movie> MOVIES = List.of(MOVIE, MOVIE);

    private static Movie createMovie(String title, String genre, int length) {
        Movie movie = new Movie(title, genre, length);
        return movie;
    }

    @BeforeEach
    public void init() {
        movieRepository = Mockito.mock(MovieRepository.class);
        movieServiceUnderTest = new MovieServiceImpl(movieRepository);
    }

    @Test
    void testListMoviesShouldListMovies() {
        //Given
        Mockito.when(movieRepository.listMovies()).thenReturn(List.of(MOVIE, MOVIE));
        List<Movie> expected = List.of(MOVIE, MOVIE);

        //When
        List<Movie> actual = movieServiceUnderTest.listMovies();

        //Then
        Assertions.assertEquals(expected, actual);
        Mockito.verify(movieRepository).listMovies();
        Mockito.verifyNoInteractions(movieRepository);

    }

}