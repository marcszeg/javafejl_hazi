package com.epam.training.ticketservice.repository.movieRepository;

public class MovieExceptionMovieExists extends Exception {
    public MovieExceptionMovieExists(String alertMessage) {
        super(alertMessage);
    }
}
