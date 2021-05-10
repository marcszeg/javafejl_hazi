package com.epam.training.ticketservice.service.impl;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.repository.RoomRepository;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;
import com.epam.training.ticketservice.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public void createRoom(String name, int rows, int columns) throws RoomExistsException {
        Room room = new Room(name, rows, columns);
        roomRepository.createRoom(room);
    }

    @Override
    public void updateRoom(String name, int rows, int columns) throws RoomNotFoundException {
        Room room = new Room(name, rows, columns);
        roomRepository.updateRoom(room);
    }

    @Override
    public void deleteRoom(String name) throws RoomNotFoundException {
        roomRepository.deleteRoom(name);
    }

    @Override
    public List<Room> listRooms() {
        return roomRepository.listRooms();
    }
}
