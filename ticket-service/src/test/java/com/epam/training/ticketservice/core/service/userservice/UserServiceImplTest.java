package com.epam.training.ticketservice.core.service.userservice;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserException;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserServiceImpl userServiceUnderTest;
    private UserRepository userRepository;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final boolean IS_ADMIN = true;
    private static final User USER = new User(USERNAME, PASSWORD, IS_ADMIN);

    @BeforeEach
    public void init() {
        userRepository = Mockito.mock(UserRepository.class);
        userServiceUnderTest = new UserServiceImpl(userRepository);
    }

    @Test
    public void testLoginShouldSetLoggedInWhenUsernameAndPasswordAreCorrect() throws UserException {
        //Given
        Mockito.when(userRepository.getUserByUsername(Mockito.any())).thenReturn(USER);

        //When
        userServiceUnderTest.logInAdmin(USERNAME, PASSWORD);

        //Then
        ArgumentCaptor<String> userNameCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername(userNameCaptor.capture());
        String actual = userNameCaptor.getValue();
        Assertions.assertEquals(USERNAME, actual);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    void testSignOutUserAfterSignIn() throws UserException {
        //Given
        Mockito.when(userRepository.getUserByUsername(Mockito.any())).thenReturn(USER);

        //When
        userServiceUnderTest.signOut();

        //Then
        assertThrows(UserException.class, () -> userServiceUnderTest.getUserInfo());
        Mockito.verifyNoMoreInteractions(userRepository);
    }

}