package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;
import com.epam.training.ticketservice.core.service.userservice.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCommandTest {
    @InjectMocks
    private UserCommand userCommandUnderTest;
    @Mock
    private UserService userService;

    private static final String SIGN_OUT_ANSWER = "Signed out";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final User USER = new User(USERNAME, PASSWORD, true);
    private static final String USER_DESCRIBE = "signed in with privileged account username";
    private static final String ADMIN_LOG_IN_SUCCESS = "Signed in as admin";

    @Test
    void testLogInAdminShouldLogInAdminUser() throws UserException {
        //When
        String actual = userCommandUnderTest.logInAdmin(USERNAME, PASSWORD);

        //Then
        assertEquals(ADMIN_LOG_IN_SUCCESS, actual);
    }

    @Test
    void testSignOutShouldSignOut() {
        //When
        String actual = userCommandUnderTest.signOut();

        //Then
        Mockito.verify(userService, Mockito.times(1)).signOut();
        assertEquals(SIGN_OUT_ANSWER, actual);
    }

    @Test
    void testDescribeAccountShouldDescribeLoggedInAccount() throws UserException {
        //Given
        Mockito.when(userService.getUserInfo()).thenReturn(USER);

        //When
        String actual = userCommandUnderTest.describeAccount();

        //Then
        assertEquals(USER_DESCRIBE, actual);
    }
}