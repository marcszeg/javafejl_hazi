package com.epam.training.ticketservice.repository.userRepository;

import com.epam.training.ticketservice.core.User;

public interface UserRepository {
    User getUserByUsername(String username) throws UserExceptionUserNotFound;
}
