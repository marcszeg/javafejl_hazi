package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;
import com.epam.training.ticketservice.core.service.userservice.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommand {
    private UserService userService;

    private UserCommand(UserService userService) {
        this.userService = userService;
    }

    @ShellMethod(value = "Sign in as admin", key = "sign in privileged")
    public String logInAdmin(String username, String password) {
        String answer;
        try {
            userService.logInAdmin(username, password);
            answer = "Signed in as admin";
        } catch (UserException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Sign out", key = "sign out")
    public String signOut() {
        String answer = "Signed out";
        userService.signOut();
        return answer;
    }

    @ShellMethod(value = "Describe the account", key = "describe account")
    public String describeAccount() {
        String answer;
        User user = null;
        try {
            user = userService.getUserInfo();
            answer = String.format("signed in with privileged account %s", user.getUsername());
        } catch (UserException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

}
