package com.epam.training.ticketservice.repository.exception;

public class RoomNotFoundException extends Exception {
    public RoomNotFoundException(String alertMessage) {
        super(alertMessage);
    }
}
