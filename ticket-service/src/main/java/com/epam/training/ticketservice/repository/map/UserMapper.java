package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.entity.UserEntity;
import com.epam.training.ticketservice.domain.User;

public interface UserMapper {
    User mapToUser(UserEntity userEntity);
}
