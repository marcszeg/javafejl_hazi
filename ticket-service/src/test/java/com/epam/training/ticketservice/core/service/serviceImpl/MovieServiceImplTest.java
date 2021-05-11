package com.epam.training.ticketservice.core.service.serviceImpl;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieExceptionMovieExists;
import com.epam.training.ticketservice.core.service.movieService.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;
    @Mock
    private MovieRepository movieRepository;

    private static final String title = "title";
    private static final String genre = "genre";
    private static final int length = 90;
    private static final Movie movie = new Movie(title, genre, length);

    @Test
    void testCreateMovieShouldCreateMovie() throws MovieExceptionMovieExists {
        //Given


        //When
        movieService.createMovie(title, genre, length);

        //Then
        Mockito.verify(movieRepository, Mockito.times(1)).createMovie(movie);
    }
}