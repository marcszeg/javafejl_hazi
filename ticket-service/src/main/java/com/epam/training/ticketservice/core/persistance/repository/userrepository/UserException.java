package com.epam.training.ticketservice.core.persistance.repository.userrepository;

public class UserException extends Exception {
    public UserException(String alertMessage) {
        super(alertMessage);
    }
}
