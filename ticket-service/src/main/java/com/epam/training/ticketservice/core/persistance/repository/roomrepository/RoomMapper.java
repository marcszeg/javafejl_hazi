package com.epam.training.ticketservice.core.persistance.repository.roomrepository;

import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.Room;

public interface RoomMapper {
    Room fromMapToRoom(RoomEntity roomEntity);

    RoomEntity fromMapToRoomEntity(Room room);
}
