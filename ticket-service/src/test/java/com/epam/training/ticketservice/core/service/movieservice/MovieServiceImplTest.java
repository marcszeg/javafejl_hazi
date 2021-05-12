package com.epam.training.ticketservice.core.service.movieservice;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;


import java.util.List;

class MovieServiceImplTest {

    private MovieServiceImpl movieServiceUnderTest;
    private MovieRepository movieRepository;

    private static final String GHOSTBUSTERS = "Ghostbusters";
    private static final String SNATCH = "Snatch";
    private static final String GENRE = "genre";
    private static final int LENGTH = 90;
    private static final MovieEntity GHOSTBUSTERS_ENTITY = new MovieEntity(GHOSTBUSTERS, GENRE, LENGTH);
    private static final MovieEntity SNATCH_ENTITY = new MovieEntity(SNATCH, GENRE, LENGTH);
    private static final Movie GHOSTBUSTERS_MOVIE = new Movie(GHOSTBUSTERS, GENRE, LENGTH);
    private static final Movie SNATCH_MOVIE = new Movie(SNATCH, GENRE, LENGTH);

    @BeforeEach
    public void init() {
        movieRepository = Mockito.mock(MovieRepository.class);
        movieServiceUnderTest = new MovieServiceImpl(movieRepository);
    }

    @Test
    void testListMoviesShouldListAllMovies() {
        //Given
        Mockito.when(movieRepository.listMovies()).thenReturn(List.of(GHOSTBUSTERS_MOVIE, SNATCH_MOVIE));
        List<Movie> expected = List.of(GHOSTBUSTERS_MOVIE, SNATCH_MOVIE);

        //When
        List<Movie> actual = movieServiceUnderTest.listMovies();

        //Then
        Assertions.assertEquals(expected, actual);
        Mockito.verify(movieRepository).listMovies();
        Mockito.verifyNoMoreInteractions(movieRepository);
    }

}