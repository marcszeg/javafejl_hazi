package com.epam.training.ticketservice.core.persistance.repository.roomRepository;

import com.epam.training.ticketservice.core.persistance.dao.RoomDao;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.Room;
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
    public void createRoom(Room room) throws RoomExceptionRoomExists {
        if (isRoomAlreadyExsists(room.getName())) {
            throw new RoomExceptionRoomExists("This room already exists");
        }
        roomDao.save(roomMapper.fromMapToRoomEntity(room));
    }

    private boolean isRoomAlreadyExsists(String name) {
        return roomDao.findById(name).isPresent();
    }

    @Override
    public void updateRoom(Room room) throws RoomExceptionRoomNotFound {
        if (!isRoomAlreadyExsists(room.getName())) {
            throw new RoomExceptionRoomNotFound("Room not found");
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
    public void deleteRoom(String name) throws RoomExceptionRoomNotFound {
        if (!isRoomAlreadyExsists(name)) {
            throw new RoomExceptionRoomNotFound("Room not found");
        }
        roomDao.deleteById(name);
    }

    @Override
    public List<Room> listRooms() {
        return roomDao.findAll().stream().map(this::fromMapToRoom).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    @Override
    public Room getRoom(String name) throws RoomExceptionRoomNotFound {
        Optional<RoomEntity> roomEntity = roomDao.findById(name);
        if (roomEntity.isEmpty()){
            throw new RoomExceptionRoomNotFound("Room not found");
        }
        Optional<Room> room = fromMapToRoom(roomEntity.get());
        return room.get();
    }

    private Optional<Room> fromMapToRoom(RoomEntity roomEntity) {
        Optional<Room> result = Optional.empty();
        return result = Optional.of(roomMapper.fromMapToRoom(roomEntity));
    }

}
