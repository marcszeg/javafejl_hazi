package com.epam.training.ticketservice.core.service.movieservice;


import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovie(String title, String genre, int length) throws MovieException {
        Movie movie = new Movie(title, genre, length);
        movieRepository.createMovie(movie);
    }

    @Override
    public void updateMovie(String title, String genre, int length) throws MovieException {
        Movie movie = new Movie(title, genre, length);
        movieRepository.updateMovie(movie);
    }

    @Override
    public void deleteMovie(String title) throws MovieException {
        movieRepository.deleteMovie(title);
    }

    @Override
    public List<Movie> listMovies() {
        return movieRepository.listMovies();
    }
}
