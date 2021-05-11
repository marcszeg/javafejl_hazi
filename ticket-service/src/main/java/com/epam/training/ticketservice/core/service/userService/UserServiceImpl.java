package com.epam.training.ticketservice.core.service.userService;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userRepository.UserRepository;
import com.epam.training.ticketservice.core.persistance.repository.userRepository.UserExceptionUserNotFound;
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
    public void logInAdmin(String username, String password) throws UserExceptionLoginFail {
        try {
            User user = userRepository.getUserByUsername(username);
            if (!user.getPassword().equals(password)) {
                throw new UserExceptionLoginFail("Login failed due to incorrect credentials");
            }
            loggedInUser = user;
        } catch (UserExceptionUserNotFound exception) {
            throw new UserExceptionLoginFail("Login failed due to incorrect credentials");
        }
    }

    @Override
    public void signOut() {
        loggedInUser = null;
    }

    @Override
    public User getUserInfo() throws UserExceptionNotSignedIn {
        if (loggedInUser == null) {
            throw new UserExceptionNotSignedIn("You are not signed in");
        }
        return loggedInUser;
    }
}
