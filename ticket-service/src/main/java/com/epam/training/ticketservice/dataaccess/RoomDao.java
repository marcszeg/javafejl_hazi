package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
}
