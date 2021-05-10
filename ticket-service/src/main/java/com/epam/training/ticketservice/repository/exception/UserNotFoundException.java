package com.epam.training.ticketservice.repository.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String alertMessage){
        super(alertMessage);
    }
}
