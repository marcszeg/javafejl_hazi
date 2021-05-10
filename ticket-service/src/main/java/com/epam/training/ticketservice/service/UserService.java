package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.service.exception.LoginFailException;
import com.epam.training.ticketservice.service.exception.NotSignedInException;

public interface UserService {

    void logInAdmin(String username, String password) throws LoginFailException;

    void signOut();

    User getUserInfo() throws NotSignedInException;

}
