package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {
}
