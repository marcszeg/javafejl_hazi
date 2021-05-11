package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.datab.entity.UserEntity;
import com.epam.training.ticketservice.core.User;

public interface UserMapper {
    User mapToUser(UserEntity userEntity);
}
