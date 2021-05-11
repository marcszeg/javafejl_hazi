package com.epam.training.ticketservice.service.userService;

import com.epam.training.ticketservice.core.User;

public interface UserService {

    void logInAdmin(String username, String password) throws LoginFailException;

    void signOut();

    User getUserInfo() throws NotSignedInException;

}
