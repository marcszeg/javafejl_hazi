package com.epam.training.ticketservice.controller;

import com.epam.training.ticketservice.domain.Room;
import com.epam.training.ticketservice.repository.exception.RoomExistsException;
import com.epam.training.ticketservice.repository.exception.RoomNotFoundException;
import com.epam.training.ticketservice.service.RoomService;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class RoomController {
    private RoomService roomService;
    private AdminMethodCheck adminMethodCheck;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public Availability isAdminSignedIn() {
        return adminMethodCheck.isAdminSignedIn();
    }

    @ShellMethod(key = "create room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String createRoom(String name, int rows, int columns) {
        String answer;
        try {
            roomService.createRoom(name, rows, columns);
            answer = "Movie created";
        } catch (RoomExistsException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(key = "update room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String updateRoom(String name, int rows, int columns) {
        String answer;
        try {
            roomService.updateRoom(name, rows, columns);
            answer = "Room updated";
        } catch (RoomNotFoundException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(key = "delete room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String deleteRoom(String name) {
        String answer;
        try {
            roomService.deleteRoom(name);
            answer = "Room deleted";
        } catch (RoomNotFoundException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(key = "list rooms")
    public String listRooms() {
        List<Room> rooms = roomService.listRooms();
        return rooms.isEmpty() ? "There are no rooms at the moment"
                : rooms.stream().map(this::mapToStringRoom)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String mapToStringRoom(Room room) {
        return String.format("Room %s with %d seats, %d rows and %d columns",
                room.getName(),
                room.getRows() * room.getColumns(),
                room.getRows(),
                room.getColumns());
    }

}
