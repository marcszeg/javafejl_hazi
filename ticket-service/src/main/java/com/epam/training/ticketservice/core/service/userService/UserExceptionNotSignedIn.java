package com.epam.training.ticketservice.core.service.userService;

public class UserExceptionNotSignedIn extends Exception {
    public UserExceptionNotSignedIn(String alertMessage) {
        super(alertMessage);
    }
}
