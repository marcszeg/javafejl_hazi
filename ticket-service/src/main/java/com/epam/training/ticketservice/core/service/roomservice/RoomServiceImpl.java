package com.epam.training.ticketservice.core.service.roomservice;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomRepository;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public void createRoom(String name, int rows, int columns) throws RoomException {
        Room room = new Room(name, rows, columns);
        roomRepository.createRoom(room);
    }

    @Override
    public void updateRoom(String name, int rows, int columns) throws RoomException {
        Room room = new Room(name, rows, columns);
        roomRepository.updateRoom(room);
    }

    @Override
    public void deleteRoom(String name) throws RoomException {
        roomRepository.deleteRoom(name);
    }

    @Override
    public List<Room> listRooms() {
        return roomRepository.listRooms();
    }
}
