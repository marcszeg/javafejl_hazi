package com.epam.training.ticketservice.service.userService;

public class NotSignedInException extends Exception {
    public NotSignedInException(String alertMessage) {
        super(alertMessage);
    }
}
