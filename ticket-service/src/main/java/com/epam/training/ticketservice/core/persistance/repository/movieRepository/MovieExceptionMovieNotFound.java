package com.epam.training.ticketservice.core.persistance.repository.movieRepository;

public class MovieExceptionMovieNotFound extends Exception {
    public MovieExceptionMovieNotFound(String alertMessage) {
        super(alertMessage);
    }
}
