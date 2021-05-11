package com.epam.training.ticketservice.datab.userDatab;

import com.epam.training.ticketservice.datab.userDatab.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {
}
