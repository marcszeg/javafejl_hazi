package com.epam.training.ticketservice.service;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;

import java.util.List;

public interface RoomService {
    void createRoom(String name, int rows, int columns) throws RoomExistsException;

    void updateRoom(String name, int rows, int columns) throws RoomNotFoundException;

    void deleteRoom(String name) throws RoomNotFoundException;

    List<Room> listRooms();
}
