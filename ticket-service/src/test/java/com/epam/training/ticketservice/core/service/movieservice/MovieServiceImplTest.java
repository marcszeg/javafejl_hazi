package com.epam.training.ticketservice.core.service.movieservice;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MovieServiceImplTest {

    private MovieServiceImpl movieServiceUnderTest;
    private MovieRepository movieRepository;

    private static final String GHOSTBUSTERS = "Ghostbusters";
    private static final String SNATCH = "Snatch";
    private static final String GENRE = "genre";
    private static final int LENGTH = 90;
    private static final int LENGTH_UPDATE = 95;
    private static final Movie GHOSTBUSTERS_MOVIE = new Movie(GHOSTBUSTERS, GENRE, LENGTH);
    private static final Movie SNATCH_MOVIE = new Movie(SNATCH, GENRE, LENGTH);
    private static final Movie SNATCH_MOVIE_UPDATE = new Movie(SNATCH, GENRE, LENGTH_UPDATE);

    @BeforeEach
    public void init() {
        movieRepository = Mockito.mock(MovieRepository.class);
        movieServiceUnderTest = new MovieServiceImpl(movieRepository);
    }

    @Test
    void testCreateMovieShouldCreateMovie() throws MovieException {
        //When
        movieServiceUnderTest.createMovie(SNATCH, GENRE, LENGTH);

        //Then
        Mockito.verify(movieRepository, Mockito.times(1)).createMovie(SNATCH_MOVIE);
    }

    @Test
    void testCreateMovieShouldThrowError() throws MovieException {
        //Given
        Mockito.doThrow(MovieException.class).when(movieRepository).createMovie(Mockito.any());

        //Then
        assertThrows(MovieException.class, () -> {
            movieServiceUnderTest.createMovie(SNATCH, GENRE, LENGTH);
        });
    }

    @Test
    void testUpdateMovieShouldUpdateMovie() throws MovieException {
        //When
        movieServiceUnderTest.updateMovie(SNATCH, GENRE, LENGTH_UPDATE);

        //Then
        Mockito.verify(movieRepository, Mockito.times(1)).updateMovie(SNATCH_MOVIE_UPDATE);
    }

    @Test
    void testDeleteMovieShouldDeleteMovie() throws MovieException {
        //When
        movieServiceUnderTest.deleteMovie(SNATCH);

        //Then
        Mockito.verify(movieRepository, Mockito.times(1)).deleteMovie(SNATCH);
    }

    @Test
    void testDeleteMovieShouldThrowError() throws MovieException {
        //Given
        Mockito.doThrow(MovieException.class).when(movieRepository).deleteMovie(Mockito.any());

        //Then
        assertThrows(MovieException.class, () -> {
            movieServiceUnderTest.deleteMovie(SNATCH);
        });
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