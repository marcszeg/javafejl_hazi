package com.epam.training.ticketservice.core.persistance.repository.roomRepository;

public class RoomExceptionRoomExists extends Exception {
    public RoomExceptionRoomExists(String alertMessage) {
        super(alertMessage);
    }
}
