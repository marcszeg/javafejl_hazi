package com.epam.training.ticketservice.core;

public class Room {

    private String name;
    private int rows;
    private int columns;

    public Room(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Room room = (Room) o;
        return (room.name == this.name
                && room.rows == this.rows
                && room.columns == this.columns);
    }

}
