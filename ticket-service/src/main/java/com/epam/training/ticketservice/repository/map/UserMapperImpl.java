package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.datab.entity.UserEntity;
import com.epam.training.ticketservice.core.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isAdmin());
    }
}
