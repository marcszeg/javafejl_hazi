package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.datab.entity.RoomEntity;
import com.epam.training.ticketservice.core.Room;

public interface RoomMapper {
    Room fromMapToRoom(RoomEntity roomEntity);

    RoomEntity fromMapToRoomEntity(Room room);
}
