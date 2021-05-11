package com.epam.training.ticketservice.core.service.screeningService;

public class ScreeningExceptionBreakOverlapping extends Exception {
    public ScreeningExceptionBreakOverlapping(String alertMessage) {
        super(alertMessage);
    }
}
