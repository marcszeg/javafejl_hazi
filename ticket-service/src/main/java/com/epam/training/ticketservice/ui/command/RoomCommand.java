package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomExists;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomNotFound;
import com.epam.training.ticketservice.core.service.roomService.RoomService;
import com.epam.training.ticketservice.ui.AdminMethodCheck;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class RoomCommand {
    private RoomService roomService;
    private AdminMethodCheck adminMethodCheck;

    public RoomCommand(RoomService roomService, AdminMethodCheck adminMethodCheck) {
        this.roomService = roomService;
        this.adminMethodCheck = adminMethodCheck;
    }

    public Availability isAdminSignedIn() {
        return adminMethodCheck.isAdminSignedIn();
    }

    @ShellMethod(value = "Create a room", key = "create room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String createRoom(String name, int rows, int columns) {
        String answer;
        try {
            roomService.createRoom(name, rows, columns);
            answer = "Room created";
        } catch (RoomExceptionRoomExists exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Update a room", key = "update room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String updateRoom(String name, int rows, int columns) {
        String answer;
        try {
            roomService.updateRoom(name, rows, columns);
            answer = "Room updated";
        } catch (RoomExceptionRoomNotFound exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Delete a room", key = "delete room")
    @ShellMethodAvailability("isAdminSignedIn")
    public String deleteRoom(String name) {
        String answer;
        try {
            roomService.deleteRoom(name);
            answer = "Room deleted";
        } catch (RoomExceptionRoomNotFound exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "List all rooms", key = "list rooms")
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
