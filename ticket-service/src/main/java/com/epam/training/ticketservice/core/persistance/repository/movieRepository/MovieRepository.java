package com.epam.training.ticketservice.core.persistance.repository.movieRepository;

import com.epam.training.ticketservice.core.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    void createMovie(Movie movie) throws MovieExceptionMovieExists;

    void updateMovie(Movie movie) throws MovieExceptionMovieNotFound;

    void deleteMovie(String title) throws MovieExceptionMovieNotFound;

    List<Movie> listMovies();

    Movie getMovie(String title) throws MovieExceptionMovieNotFound;

}
