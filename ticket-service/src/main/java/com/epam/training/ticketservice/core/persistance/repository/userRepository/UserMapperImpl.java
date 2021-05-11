package com.epam.training.ticketservice.core.persistance.repository.userRepository;

import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import com.epam.training.ticketservice.core.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserEntity userEntity) {
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isAdmin());
    }
}
