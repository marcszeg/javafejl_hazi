package com.epam.training.ticketservice.core.persistance.repository.userRepository;

import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import com.epam.training.ticketservice.core.User;

public interface UserMapper {
    User mapToUser(UserEntity userEntity);
}
