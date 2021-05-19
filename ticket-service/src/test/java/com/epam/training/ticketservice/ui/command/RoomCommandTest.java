package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.service.roomservice.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoomCommandTest {
    @InjectMocks
    private RoomCommand roomCommandUnderTest;
    @Mock
    private RoomService roomService;

    private static final String SPIELBERG = "Spielberg";
    private static final int ROWS = 20;
    private static final int COLUMNS = 20;
    private static final int ROWS_UPDATE = 25;
    private static final String ROOM_CREATE_SUCCESS = "Room created";
    private static final String ROOM_UPDATE_SUCCESS = "Room updated";
    private static final String ROOM_DELETE_SUCCESS = "Room deleted";

    @Test
    void testCreateRoomShouldCreateARoom() throws RoomException {
        //When
        String actual = roomCommandUnderTest.createRoom(SPIELBERG, ROWS, COLUMNS);

        //Then
        Mockito.verify(roomService, Mockito.times(1)).createRoom(SPIELBERG, ROWS, COLUMNS);
        assertEquals(ROOM_CREATE_SUCCESS, actual);
    }

    @Test
    void testUpdateRoomShouldUpdateRoom() throws RoomException {
        //When
        String actual = roomCommandUnderTest.updateRoom(SPIELBERG, ROWS_UPDATE, COLUMNS);

        //Then
        Mockito.verify(roomService, Mockito.times(1)).updateRoom(SPIELBERG, ROWS_UPDATE, COLUMNS);
        assertEquals(ROOM_UPDATE_SUCCESS, actual);
    }

    @Test
    void testDeleteRoomShouldDeleteRoom() throws RoomException {
        //When
        String actual = roomCommandUnderTest.deleteRoom(SPIELBERG);

        //Then
        Mockito.verify(roomService, Mockito.times(1)).deleteRoom(SPIELBERG);
        assertEquals(ROOM_DELETE_SUCCESS, actual);
    }

}