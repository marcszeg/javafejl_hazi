package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

public class ScreeningException extends Exception {
    public ScreeningException(String alertMessage) {
        super(alertMessage);
    }
}
