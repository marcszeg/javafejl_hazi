package com.epam.training.ticketservice.core.persistance.repository.userrepository;

import com.epam.training.ticketservice.core.persistance.dao.UserDao;
import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import com.epam.training.ticketservice.core.User;
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
    public User getUserByUsername(String username) throws UserException {
        Optional<UserEntity> userEntity = userDao.findById(username);
        if (userEntity.isEmpty()) {
            throw new UserException("User not found");
        }
        return userMapper.fromUserEntityToUser(userEntity.get());
    }
}
