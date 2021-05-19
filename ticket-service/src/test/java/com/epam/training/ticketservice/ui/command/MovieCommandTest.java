package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.service.movieservice.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovieCommandTest {
    @InjectMocks
    private MovieCommand movieCommandUnderTest;
    @Mock
    private MovieService movieService;

    private static final String SNATCH = "Snatch";
    private static final String GENRE = "action";
    private static final int LENGTH = 90;
    private static final int LENGTH_UPDATE = 95;
    private static final String MOVIE_CREATE_SUCCESS = "Movie created";
    private static final String MOVIE_UPDATE_SUCCESS = "Movie updated";
    private static final String MOVIE_DELETE_SUCCESS = "Movie deleted";

    @Test
    void testCreateMovieShouldCreateMovie() throws MovieException {
        //When
        String actual = movieCommandUnderTest.createMovie(SNATCH, GENRE, LENGTH);

        //Then
        Mockito.verify(movieService, Mockito.times(1)).createMovie(SNATCH, GENRE, LENGTH);
        assertEquals(MOVIE_CREATE_SUCCESS, actual);
    }

    @Test
    void testUpdateMovieShouldUpdateAMovie() throws MovieException {
        //When
        String actual = movieCommandUnderTest.updateMovie(SNATCH, GENRE, LENGTH_UPDATE);

        //Then
        Mockito.verify(movieService, Mockito.times(1)).updateMovie(SNATCH, GENRE, LENGTH_UPDATE);
        assertEquals(MOVIE_UPDATE_SUCCESS, actual);
    }

    @Test
    void testDeleteMovieShouldDeleteMovie() throws MovieException {
        //When
        String actual = movieCommandUnderTest.deleteMovie(SNATCH);

        //Then
        Mockito.verify(movieService, Mockito.times(1)).deleteMovie(SNATCH);
        assertEquals(MOVIE_DELETE_SUCCESS, actual);
    }
}