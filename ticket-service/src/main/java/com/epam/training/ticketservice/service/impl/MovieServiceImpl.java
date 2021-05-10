package com.epam.training.ticketservice.service.impl;


import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.repository.MovieRepository;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovie(String title, String genre, int length) throws MovieExistsException {
        Movie movie = new Movie(title, genre, length);
        movieRepository.createMovie(movie);
    }

    @Override
    public void updateMovie(String title, String genre, int length) throws MovieNotFoundException {
        Movie movie = new Movie(title, genre, length);
        movieRepository.updateMovie(movie);
    }

    @Override
    public void deleteMovie(String title) throws MovieNotFoundException {
        movieRepository.deleteMovie(title);
    }

    @Override
    public List<Movie> listMovies() {
        return movieRepository.listMovies();
    }
}
