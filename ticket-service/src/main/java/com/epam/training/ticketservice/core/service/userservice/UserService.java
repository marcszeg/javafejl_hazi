package com.epam.training.ticketservice.core.service.userservice;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;

public interface UserService {

    void logInAdmin(String username, String password) throws UserException;

    void signOut();

    User getUserInfo() throws UserException;

}
