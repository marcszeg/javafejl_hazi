package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    void createMovie(Movie movie) throws MovieExistsException;

    void updateMovie(Movie movie) throws MovieNotFoundException;

    void deleteMovie(String title) throws MovieNotFoundException;

    List<Movie> listMovies();

}
