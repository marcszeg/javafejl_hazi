package com.epam.training.ticketservice.core.persistance.repository.userrepository;

import com.epam.training.ticketservice.core.User;

public interface UserRepository {
    User getUserByUsername(String username) throws UserException;
}
