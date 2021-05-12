package com.epam.training.ticketservice.core.persistance.repository.userrepository;

import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import com.epam.training.ticketservice.core.User;

public interface UserMapper {
    User fromUserEntityToUser(UserEntity userEntity);
}
