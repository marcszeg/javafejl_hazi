package com.epam.training.ticketservice.core.persistance.repository.userRepository;

public class UserExceptionUserNotFound extends Exception {
    public UserExceptionUserNotFound(String alertMessage) {
        super(alertMessage);
    }
}
