package com.epam.training.ticketservice.repository.roomRepository;

import com.epam.training.ticketservice.datab.roomDatab.RoomEntity;
import com.epam.training.ticketservice.core.Room;

public interface RoomMapper {
    Room fromMapToRoom(RoomEntity roomEntity);

    RoomEntity fromMapToRoomEntity(Room room);
}
