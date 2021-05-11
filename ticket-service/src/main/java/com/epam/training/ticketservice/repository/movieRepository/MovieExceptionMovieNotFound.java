package com.epam.training.ticketservice.repository.movieRepository;

public class MovieExceptionMovieNotFound extends Exception {
    public MovieExceptionMovieNotFound(String alertMessage) {
        super(alertMessage);
    }
}
