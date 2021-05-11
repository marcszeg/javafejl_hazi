package com.epam.training.ticketservice.core.persistance.repository.screeningRepository;

public class ScreeningExceptionScreeeningExists extends Exception {
    public ScreeningExceptionScreeeningExists(String alertMessage) {
        super(alertMessage);
    }
}
