package com.epam.training.ticketservice.repository.roomRepository;

public class RoomExceptionRoomNotFound extends Exception {
    public RoomExceptionRoomNotFound(String alertMessage) {
        super(alertMessage);
    }
}
