package com.epam.training.ticketservice.core.persistance.repository.movieRepository;

public class MovieExceptionMovieExists extends Exception {
    public MovieExceptionMovieExists(String alertMessage) {
        super(alertMessage);
    }
}
