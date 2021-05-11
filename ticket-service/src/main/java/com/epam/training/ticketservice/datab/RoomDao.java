package com.epam.training.ticketservice.datab;

import com.epam.training.ticketservice.datab.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
}
