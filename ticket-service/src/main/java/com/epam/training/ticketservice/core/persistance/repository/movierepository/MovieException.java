package com.epam.training.ticketservice.core.persistance.repository.movierepository;

public class MovieException extends Exception {
    public MovieException(String alertMessage) {
        super(alertMessage);
    }
}
