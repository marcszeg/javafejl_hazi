package com.epam.training.ticketservice.repository.repositoryImpl;

import com.epam.training.ticketservice.datab.RoomDao;
import com.epam.training.ticketservice.datab.entity.RoomEntity;
import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.repository.RoomRepository;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;
import com.epam.training.ticketservice.repository.map.RoomMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private RoomDao roomDao;
    private RoomMapper roomMapper;

    public RoomRepositoryImpl(RoomDao roomDao, RoomMapper roomMapper) {
        this.roomDao = roomDao;
        this.roomMapper = roomMapper;
    }

    @Override
    public void createRoom(Room room) throws RoomExistsException {
        if (isRoomAlreadyExsists(room.getName())) {
            throw new RoomExistsException("This room already exists");
        }
        roomDao.save(roomMapper.fromMapToRoomEntity(room));
    }

    private boolean isRoomAlreadyExsists(String name) {
        return roomDao.findById(name).isPresent();
    }

    @Override
    public void updateRoom(Room room) throws RoomNotFoundException {
        if (!isRoomAlreadyExsists(room.getName())) {
            throw new RoomNotFoundException("Room not found");
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
        if (!isRoomAlreadyExsists(name)) {
            throw new RoomNotFoundException("Room not found");
        }
        roomDao.deleteById(name);
    }

    @Override
    public List<Room> listRooms() {
        return roomDao.findAll().stream().map(this::fromMapToRoom).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    private Optional<Room> fromMapToRoom(RoomEntity roomEntity) {
        Optional<Room> result = Optional.empty();
        return result = Optional.of(roomMapper.fromMapToRoom(roomEntity));
    }

}
