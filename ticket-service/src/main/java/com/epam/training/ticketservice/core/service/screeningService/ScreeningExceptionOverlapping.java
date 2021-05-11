package com.epam.training.ticketservice.core.service.screeningService;

public class ScreeningExceptionOverlapping extends Exception {
    public ScreeningExceptionOverlapping(String alertMessage) {
        super(alertMessage);
    }
}
