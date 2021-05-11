package com.epam.training.ticketservice.core.persistance.repository.roomRepository;

import com.epam.training.ticketservice.core.Room;

import java.util.List;

public interface RoomRepository {

    void createRoom(Room room) throws RoomExceptionRoomExists;

    void updateRoom(Room room) throws RoomExceptionRoomNotFound;

    void deleteRoom(String name) throws RoomExceptionRoomNotFound;

    List<Room> listRooms();

    Room getRoom(String name) throws RoomExceptionRoomNotFound;

}
