package com.epam.training.ticketservice.service.movieService;


import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.repository.movieRepository.MovieExceptionMovieExists;
import com.epam.training.ticketservice.repository.movieRepository.MovieExceptionMovieNotFound;

import java.util.List;

public interface MovieService {
    void createMovie(String title, String genre, int length) throws MovieExceptionMovieExists;

    void updateMovie(String title, String genre, int length) throws MovieExceptionMovieNotFound;

    void deleteMovie(String title) throws MovieExceptionMovieNotFound;

    List<Movie> listMovies();

}
