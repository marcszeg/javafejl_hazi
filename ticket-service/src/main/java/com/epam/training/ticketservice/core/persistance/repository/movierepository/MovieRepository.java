package com.epam.training.ticketservice.core.persistance.repository.movierepository;

import com.epam.training.ticketservice.core.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    void createMovie(Movie movie) throws MovieException;

    void updateMovie(Movie movie) throws MovieException;

    void deleteMovie(String title) throws MovieException;

    List<Movie> listMovies();

    Movie getMovie(String title) throws MovieException;

}
