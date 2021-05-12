package com.epam.training.ticketservice.core.service.roomservice;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RoomServiceImplTest {

    private RoomServiceImpl roomServiceUnderTest;
    private RoomRepository roomRepository;

    private static final String VANGELIS = "Vangelis";
    private static final String SPIELBERG = "Spielberg";
    private static final int ROWS = 25;
    private static final int COLUMNS = 20;
    private static final RoomEntity VANGELIS_ENTITY = new RoomEntity(VANGELIS, ROWS, COLUMNS);
    private static final RoomEntity SPIELBERG_ENTITY = new RoomEntity(SPIELBERG, ROWS, COLUMNS);
    private static final Room VANGELIS_ROOM = new Room(VANGELIS, ROWS, COLUMNS);
    private static final Room SPIELBERG_ROOM = new Room(SPIELBERG, ROWS, COLUMNS);

    @BeforeEach
    public void init() {
        roomRepository = Mockito.mock(RoomRepository.class);
        roomServiceUnderTest = new RoomServiceImpl(roomRepository);
    }

    @Test
    void testListRoomsShouldListAllRooms() {
        //Given
        Mockito.when(roomRepository.listRooms()).thenReturn(List.of(VANGELIS_ROOM, SPIELBERG_ROOM));
        List<Room> expected = List.of(VANGELIS_ROOM, SPIELBERG_ROOM);

        //When
        List<Room> actual = roomServiceUnderTest.listRooms();

        //Then
        Assertions.assertEquals(expected, actual);
        Mockito.verify(roomRepository).listRooms();
        Mockito.verifyNoMoreInteractions(roomRepository);
    }

}