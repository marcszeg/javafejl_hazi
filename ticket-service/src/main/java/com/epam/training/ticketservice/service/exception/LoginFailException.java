package com.epam.training.ticketservice.service.exception;

public class LoginFailException extends Exception {
    public LoginFailException(String alertMessage){
        super(alertMessage);
    }
}
