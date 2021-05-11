package com.epam.training.ticketservice.service.userService;

public class LoginFailException extends Exception {
    public LoginFailException(String alertMessage) {
        super(alertMessage);
    }
}
