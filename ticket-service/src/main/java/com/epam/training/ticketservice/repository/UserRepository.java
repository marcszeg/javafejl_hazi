package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.repository.exception.UserNotFoundException;

public interface UserRepository {
    User getUserByUsername(String username) throws UserNotFoundException;
}
