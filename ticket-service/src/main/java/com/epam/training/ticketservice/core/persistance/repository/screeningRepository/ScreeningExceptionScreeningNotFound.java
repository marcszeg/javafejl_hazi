package com.epam.training.ticketservice.core.persistance.repository.screeningRepository;

public class ScreeningExceptionScreeningNotFound extends Exception {
    public ScreeningExceptionScreeningNotFound(String alertMessage) {
        super(alertMessage);
    }
}
