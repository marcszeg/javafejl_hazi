package com.epam.training.ticketservice.repository.userRepository;

public class UserExceptionUserNotFound extends Exception {
    public UserExceptionUserNotFound(String alertMessage) {
        super(alertMessage);
    }
}
