package com.epam.training.ticketservice.core.persistance.repository.userrepository;

import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperImplTest {

    private UserMapperImpl userMapperUnderTest = new UserMapperImpl();

    private static final User USER = new User("user", "password", true);
    private static final UserEntity USER_ENTITY = new UserEntity("user", "password", true);

    @Test
    void testFromUserEntityToUserShouldReturnUser() {
        //When
        User actual = userMapperUnderTest.fromUserEntityToUser(USER_ENTITY);

        //Then
        Assertions.assertEquals(USER, actual);
    }


}