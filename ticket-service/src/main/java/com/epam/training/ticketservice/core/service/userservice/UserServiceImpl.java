package com.epam.training.ticketservice.core.service.userservice;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        loggedInUser = null;
    }

    @Override
    public void logInAdmin(String username, String password) throws UserException {
        try {
            User user = userRepository.getUserByUsername(username);
            if (!user.getPassword().equals(password)) {
                throw new UserException("Login failed due to incorrect credentials");
            }
            loggedInUser = user;
        } catch (UserException exception) {
            throw new UserException("Login failed due to incorrect credentials");
        }
    }

    @Override
    public void signOut() {
        loggedInUser = null;
    }

    @Override
    public User getUserInfo() throws UserException {
        if (loggedInUser == null) {
            throw new UserException("You are not signed in");
        }
        return loggedInUser;
    }
}
