package com.epam.training.ticketservice.repository.roomRepository;

public class RoomExceptionRoomExists extends Exception {
    public RoomExceptionRoomExists(String alertMessage) {
        super(alertMessage);
    }
}
