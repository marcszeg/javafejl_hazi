package com.epam.training.ticketservice.repository.exception;

public class RoomExistsException extends Exception {
    public RoomExistsException(String alertMessage){
        super(alertMessage);
    }
}
