package com.epam.training.ticketservice.repository.impl;

import com.epam.training.ticketservice.dataaccess.UserDao;
import com.epam.training.ticketservice.dataaccess.entity.UserEntity;
import com.epam.training.ticketservice.domain.User;
import com.epam.training.ticketservice.repository.UserRepository;
import com.epam.training.ticketservice.repository.exception.UserNotFoundException;
import com.epam.training.ticketservice.repository.map.UserMapper;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao;
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userDao.findById(username);
        if(userEntity.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return userMapper.mapToUser(userEntity.get());
    }
}
