package com.epam.training.ticketservice.datab.roomDatab;

import com.epam.training.ticketservice.datab.roomDatab.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity, String> {
}
