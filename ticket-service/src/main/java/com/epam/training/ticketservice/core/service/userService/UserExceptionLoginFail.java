package com.epam.training.ticketservice.core.service.userService;

public class UserExceptionLoginFail extends Exception {
    public UserExceptionLoginFail(String alertMessage) {
        super(alertMessage);
    }
}
