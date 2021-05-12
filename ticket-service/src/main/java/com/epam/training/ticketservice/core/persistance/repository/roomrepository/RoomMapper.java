package com.epam.training.ticketservice.core.persistance.repository.roomrepository;

import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.Room;

public interface RoomMapper {
    Room fromRoomEntityToRoom(RoomEntity roomEntity);

    RoomEntity fromRoomToRoomEntity(Room room);
}
