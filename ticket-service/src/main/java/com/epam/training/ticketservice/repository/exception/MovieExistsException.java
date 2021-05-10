package com.epam.training.ticketservice.repository.exception;

public class MovieExistsException extends Exception {
    public MovieExistsException(String alertMessage) {
        super(alertMessage);
    }
}
