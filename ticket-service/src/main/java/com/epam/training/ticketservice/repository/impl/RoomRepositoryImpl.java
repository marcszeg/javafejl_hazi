package com.epam.training.ticketservice.repository.impl;

import com.epam.training.ticketservice.dataaccess.RoomDao;
import com.epam.training.ticketservice.dataaccess.entity.RoomEntity;
import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.repository.RoomRepository;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;
import com.epam.training.ticketservice.repository.map.RoomMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private RoomDao roomDao;
    private RoomMapper roomMapper;

    @Override
    public void createRoom(Room room) throws RoomExistsException {
        if(isRoomAlreadyExsists(room.getName())){
            throw new RoomExistsException(String.format("This room already exists"));
        }
        roomDao.save(roomMapper.fromMapToRoomEntity(room));
    }

    private boolean isRoomAlreadyExsists(String name) {
        return roomDao.findById(name).isPresent();
    }

    @Override
    public void updateRoom(Room room) throws RoomNotFoundException {
        if (!isRoomAlreadyExsists(room.getName())){
            throw new RoomNotFoundException(String.format("Room not found"));
        }
        RoomEntity roomEntity = getRoomByName(room.getName());
        roomEntity.setRows(room.getRows());
        roomEntity.setColumns(room.getColumns());
        roomDao.save(roomEntity);
    }

    private RoomEntity getRoomByName(String name) {
        Optional<RoomEntity> roomEntity = roomDao.findById(name);
        return roomEntity.get();
    }

    @Override
    public void deleteRoom(String name) throws RoomNotFoundException {
        if (!isRoomAlreadyExsists(name)){
            throw new RoomNotFoundException(String.format("Room not found"));
        }
        roomDao.deleteById(name);
    }

    @Override
    public List<Room> listRooms() {
        return null;
    }
}
