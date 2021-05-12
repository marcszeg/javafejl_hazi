package com.epam.training.ticketservice.core.service.screeningservice;

public class ScreeningExceptionOverlapping extends Exception {
    public ScreeningExceptionOverlapping(String alertMessage) {
        super(alertMessage);
    }
}
