package com.epam.training.ticketservice.core.persistance.repository.roomrepository;

import com.epam.training.ticketservice.core.Room;

import java.util.List;

public interface RoomRepository {

    void createRoom(Room room) throws RoomException;

    void updateRoom(Room room) throws RoomException;

    void deleteRoom(String name) throws RoomException;

    List<Room> listRooms();

    Room getRoom(String name) throws RoomException;

}
