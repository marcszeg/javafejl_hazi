package com.epam.training.ticketservice.core.persistance.repository.roomRepository;

public class RoomExceptionRoomNotFound extends Exception {
    public RoomExceptionRoomNotFound(String alertMessage) {
        super(alertMessage);
    }
}
