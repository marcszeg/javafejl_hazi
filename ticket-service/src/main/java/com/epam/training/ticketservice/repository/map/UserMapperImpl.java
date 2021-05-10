package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.UserDao;
import com.epam.training.ticketservice.dataaccess.entity.UserEntity;
import com.epam.training.ticketservice.domain.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isAdmin());
    }
}
