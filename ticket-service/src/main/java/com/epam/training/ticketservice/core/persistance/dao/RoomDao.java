package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
}
