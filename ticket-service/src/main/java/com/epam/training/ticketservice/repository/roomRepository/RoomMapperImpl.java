package com.epam.training.ticketservice.repository.roomRepository;

import com.epam.training.ticketservice.datab.roomDatab.RoomEntity;
import com.epam.training.ticketservice.core.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl implements RoomMapper {

    public RoomMapperImpl() {
    }

    @Override
    public Room fromMapToRoom(RoomEntity roomEntity) {
        return new Room(roomEntity.getName(), roomEntity.getRows(), roomEntity.getColumns());
    }

    @Override
    public RoomEntity fromMapToRoomEntity(Room room) {
        return new RoomEntity(room.getName(), room.getRows(), room.getColumns());
    }
}
