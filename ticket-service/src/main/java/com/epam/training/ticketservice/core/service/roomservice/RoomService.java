package com.epam.training.ticketservice.core.service.roomservice;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;

import java.util.List;

public interface RoomService {
    void createRoom(String name, int rows, int columns) throws RoomException;

    void updateRoom(String name, int rows, int columns) throws RoomException;

    void deleteRoom(String name) throws RoomException;

    List<Room> listRooms();
}
