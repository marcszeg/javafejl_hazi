package com.epam.training.ticketservice.core.service.movieservice;


import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;

import java.util.List;

public interface MovieService {
    void createMovie(String title, String genre, int length) throws MovieException;

    void updateMovie(String title, String genre, int length) throws MovieException;

    void deleteMovie(String title) throws MovieException;

    List<Movie> listMovies();

}
