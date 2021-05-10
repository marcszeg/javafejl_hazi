package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.repository.UserRepository;
import com.epam.training.ticketservice.repository.exception.UserNotFoundException;
import com.epam.training.ticketservice.service.exception.LoginFailException;
import com.epam.training.ticketservice.service.exception.NotSignedInException;
import com.epam.training.ticketservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private User loggedInUser;

    @Override
    public void logInAdmin(String username, String password) throws LoginFailException {
        try {
            User user = userRepository.getUserByUsername(username);
            if (!user.getPassword().equals(password)) {
                throw new LoginFailException("Login failed due to incorrect credentials");
            }
            loggedInUser = user;
        } catch (UserNotFoundException exception) {
            throw new LoginFailException("Login failed due to incorrect credentials");
        }
    }

    @Override
    public void signOut() {
        loggedInUser = null;
    }

    @Override
    public User getUserInfo() throws NotSignedInException {
        if (loggedInUser == null) {
            throw new NotSignedInException("You are not signed in");
        }
        return loggedInUser;
    }
}
