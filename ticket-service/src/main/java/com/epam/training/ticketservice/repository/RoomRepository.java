package com.epam.training.ticketservice.repository;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;

import java.util.List;

public interface RoomRepository {

    void createRoom(Room room) throws RoomExistsException;

    void updateRoom(Room room) throws RoomNotFoundException;

    void deleteRoom(String name) throws RoomNotFoundException;

    List<Room> listRooms();

}
