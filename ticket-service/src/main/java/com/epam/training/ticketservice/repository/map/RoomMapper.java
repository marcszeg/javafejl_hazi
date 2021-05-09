package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.entity.RoomEntity;
import com.epam.training.ticketservice.domain.Room;

public interface RoomMapper {
    Room fromMapToRoom(RoomEntity roomEntity);

    RoomEntity fromMapToEntityRoom(Room room);
}
