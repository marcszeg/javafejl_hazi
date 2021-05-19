package com.epam.training.ticketservice.core.persistance.repository.roomrepository;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomMapperImplTest {

    private  RoomMapperImpl roomMapperUderTest = new RoomMapperImpl();

    private static final Room ROOM = new Room("Spielberg", 20, 25);
    private static final RoomEntity ROOM_ENTITY = new RoomEntity("Spielberg", 20, 25);

    @Test
    void testFromRoomEntityToRoomShouldReturnRoom() {
        //When
        Room actual = roomMapperUderTest.fromRoomEntityToRoom(ROOM_ENTITY);

        //Then
        Assertions.assertEquals(ROOM, actual);
    }

    @Test
    void testFromRoomToRoomEntityShouldReturnRoomEntity() {
        //When
        RoomEntity actual = roomMapperUderTest.fromRoomToRoomEntity(ROOM);

        //Then
        Assertions.assertEquals(ROOM_ENTITY, actual);
    }

}