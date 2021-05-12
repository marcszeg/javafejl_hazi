package com.epam.training.ticketservice.core.service.screeningservice;

public class ScreeningExceptionBreakOverlapping extends Exception {
    public ScreeningExceptionBreakOverlapping(String alertMessage) {
        super(alertMessage);
    }
}
