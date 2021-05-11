package com.epam.training.ticketservice.repository.repositoryImpl;

import com.epam.training.ticketservice.datab.UserDao;
import com.epam.training.ticketservice.datab.entity.UserEntity;
import com.epam.training.ticketservice.core.User;
import com.epam.training.ticketservice.repository.UserRepository;
import com.epam.training.ticketservice.repository.exception.UserNotFoundException;
import com.epam.training.ticketservice.repository.map.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao;
    private UserMapper userMapper;

    public UserRepositoryImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userDao.findById(username);
        if (userEntity.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return userMapper.mapToUser(userEntity.get());
    }
}
