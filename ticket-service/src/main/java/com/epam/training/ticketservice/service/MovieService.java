package com.epam.training.ticketservice.service;


import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    void createMovie(String title, String genre, int length) throws MovieExistsException;

    void updateMovie(String title, String genre, int length) throws MovieNotFoundException;

    void deleteMovie(String title) throws MovieNotFoundException;

    List<Movie> listMovies();

}
