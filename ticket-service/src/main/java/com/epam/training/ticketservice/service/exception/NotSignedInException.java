package com.epam.training.ticketservice.service.exception;

public class NotSignedInException extends Exception {
    public NotSignedInException(String alertMessage) {
        super(alertMessage);
    }
}
