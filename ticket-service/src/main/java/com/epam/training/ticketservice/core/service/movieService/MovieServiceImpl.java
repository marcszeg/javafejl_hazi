package com.epam.training.ticketservice.core.service.movieService;


import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieExceptionMovieExists;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieExceptionMovieNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void createMovie(String title, String genre, int length) throws MovieExceptionMovieExists {
        Movie movie = new Movie(title, genre, length);
        movieRepository.createMovie(movie);
    }

    @Override
    public void updateMovie(String title, String genre, int length) throws MovieExceptionMovieNotFound {
        Movie movie = new Movie(title, genre, length);
        movieRepository.updateMovie(movie);
    }

    @Override
    public void deleteMovie(String title) throws MovieExceptionMovieNotFound {
        movieRepository.deleteMovie(title);
    }

    @Override
    public List<Movie> listMovies() {
        return movieRepository.listMovies();
    }
}
