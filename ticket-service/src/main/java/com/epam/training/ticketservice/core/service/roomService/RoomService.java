package com.epam.training.ticketservice.core.service.roomService;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomExists;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomNotFound;

import java.util.List;

public interface RoomService {
    void createRoom(String name, int rows, int columns) throws RoomExceptionRoomExists;

    void updateRoom(String name, int rows, int columns) throws RoomExceptionRoomNotFound;

    void deleteRoom(String name) throws RoomExceptionRoomNotFound;

    List<Room> listRooms();
}