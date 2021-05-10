package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {
}
