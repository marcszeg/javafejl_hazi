package com.epam.training.ticketservice.core.service.userService;

import com.epam.training.ticketservice.core.User;

public interface UserService {

    void logInAdmin(String username, String password) throws UserExceptionLoginFail;

    void signOut();

    User getUserInfo() throws UserExceptionNotSignedIn;

}
