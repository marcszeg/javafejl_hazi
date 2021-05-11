package com.epam.training.ticketservice.repository.userRepository;

import com.epam.training.ticketservice.datab.userDatab.UserEntity;
import com.epam.training.ticketservice.core.User;

public interface UserMapper {
    User mapToUser(UserEntity userEntity);
}
