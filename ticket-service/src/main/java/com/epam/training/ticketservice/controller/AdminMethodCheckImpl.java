package com.epam.training.ticketservice.controller;

import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.service.UserService;
import com.epam.training.ticketservice.service.exception.NotSignedInException;
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
        } catch (NotSignedInException exception) {
            return Availability.unavailable("You are not signed in");
        }
    }
}
