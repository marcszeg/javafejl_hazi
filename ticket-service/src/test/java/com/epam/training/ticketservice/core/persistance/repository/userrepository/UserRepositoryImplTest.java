package com.epam.training.ticketservice.core.persistance.repository.userrepository;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.dao.UserDao;
import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import com.epam.training.ticketservice.core.service.userservice.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepositoryImpl userRepositoryUnderTest;
    private UserDao userDao;
    private UserMapper userMapper;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final boolean IS_ADMIN = true;
    private static final User USER = new User(USERNAME, PASSWORD, IS_ADMIN);
    private static final UserEntity USER_ENTITY = new UserEntity(USERNAME, PASSWORD, IS_ADMIN);

    @BeforeEach
    public void init() {
        userDao = Mockito.mock(UserDao.class);
        userMapper = Mockito.mock(UserMapper.class);
        userRepositoryUnderTest = new UserRepositoryImpl(userDao, userMapper);
    }

    @Test
    void testGetUserInfo() throws UserException {
        //Given
        Mockito.when(userDao.findById(Mockito.any())).thenReturn(Optional.of(USER_ENTITY));
        Mockito.when(userMapper.fromUserEntityToUser(Mockito.any())).thenReturn(USER);

        //When
        User actual = userRepositoryUnderTest.getUserByUsername(USERNAME);

        //Then
        Assertions.assertEquals(USER, actual);
    }

}