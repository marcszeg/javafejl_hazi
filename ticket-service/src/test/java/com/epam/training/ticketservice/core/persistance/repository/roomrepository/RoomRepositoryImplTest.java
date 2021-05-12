package com.epam.training.ticketservice.core.persistance.repository.roomrepository;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.dao.RoomDao;
import com.epam.training.ticketservice.core.persistance.dao.UserDao;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserMapper;
import com.epam.training.ticketservice.core.persistance.repository.userrepository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepositoryImplTest {

    private RoomRepositoryImpl roomRepositoryUnderTest;
    private RoomDao roomDao;
    private RoomMapper roomMapper;

    private static final String VANGELIS = "Vangelis";
    private static final String SPIELBERG = "Spielberg";
    private static final int ROWS = 25;
    private static final int COLUMNS = 20;
    private static final Room VANGELIS_ROOM = new Room(VANGELIS, ROWS, COLUMNS);
    private static final RoomEntity VANGELIS_ROOM_ENTITY = new RoomEntity(VANGELIS, ROWS, COLUMNS);
    private static final List<Room> ROOM_LIST = List.of(VANGELIS_ROOM, VANGELIS_ROOM);
    private static final List<RoomEntity> ROOM_ENTITY_LIST = List.of(VANGELIS_ROOM_ENTITY, VANGELIS_ROOM_ENTITY);

    @BeforeEach
    public void init() {
        roomDao = Mockito.mock(RoomDao.class);
        roomMapper = Mockito.mock(RoomMapper.class);
        roomRepositoryUnderTest = new RoomRepositoryImpl(roomDao, roomMapper);
    }

    @Test
    void testCreateRoomShouldCreateGivenRoom() throws RoomException {
        //Given
        Mockito.when(roomDao.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(roomMapper.fromRoomToRoomEntity(Mockito.any())).thenReturn(VANGELIS_ROOM_ENTITY);

        //When
        roomRepositoryUnderTest.createRoom(VANGELIS_ROOM);

        //Then
        Mockito.verify(roomDao, Mockito.times(1)).save(VANGELIS_ROOM_ENTITY);
    }

    @Test
    void testListAllRoomsShouldListAllRooms() throws RoomException {
        //Given
        Mockito.when(roomDao.findAll()).thenReturn(ROOM_ENTITY_LIST);
        Mockito.when(roomMapper.fromRoomEntityToRoom(Mockito.any())).thenReturn(VANGELIS_ROOM);

        //When
        List<Room> actual = roomRepositoryUnderTest.listRooms();

        //Then
        Assertions.assertEquals(ROOM_LIST, actual);
    }

    @Test
    void testDeleteRoomShouldDeleteGivenRoom() throws RoomException {
        //Given
        Mockito.when(roomDao.findById(Mockito.any())).thenReturn(Optional.of(VANGELIS_ROOM_ENTITY));

        //When
        roomRepositoryUnderTest.deleteRoom(VANGELIS);

        //Then
        Mockito.verify(roomDao, Mockito.times(1)).deleteById(VANGELIS);

    }

}