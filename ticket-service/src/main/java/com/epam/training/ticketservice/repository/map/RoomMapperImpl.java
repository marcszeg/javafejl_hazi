package com.epam.training.ticketservice.repository.map;

import com.epam.training.ticketservice.dataaccess.entity.RoomEntity;
import com.epam.training.ticketservice.domain.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl implements RoomMapper{

    @Override
    public Room fromMapToRoom(RoomEntity roomEntity) {
        return new Room(roomEntity.getName(), roomEntity.getRows(), roomEntity.getColumns());
    }

    @Override
    public RoomEntity fromMapToEntityRoom(Room room) {
        return new RoomEntity(room.getName(), room.getRows(), room.getColumns());
    }
}