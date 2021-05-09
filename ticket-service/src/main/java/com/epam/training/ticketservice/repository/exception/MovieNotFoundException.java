package com.epam.training.ticketservice.repository.exception;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String alertMessage){
        super(alertMessage);
    }
}
