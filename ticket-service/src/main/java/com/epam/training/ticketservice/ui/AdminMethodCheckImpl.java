package com.epam.training.ticketservice.ui;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;
import com.epam.training.ticketservice.core.service.userservice.UserService;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;

@Service
public class AdminMethodCheckImpl implements AdminMethodCheck {

    private UserService userService;

    public AdminMethodCheckImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Availability isAdminSignedIn() {
        try {
            User user = userService.getUserInfo();
            //return Availability.available();
            return user.isAdmin()
                    ? Availability.available()
                    : Availability.unavailable("admin");
        } catch (UserException exception) {
            return Availability.unavailable("you are not signed in as admin");
        }
    }
}
