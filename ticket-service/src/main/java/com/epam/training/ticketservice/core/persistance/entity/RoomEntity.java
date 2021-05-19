package com.epam.training.ticketservice.core.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomEntity {

    @Id
    private String name;
    private int rows;
    private int columns;


    public RoomEntity(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    public RoomEntity() {
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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        RoomEntity roomEntity = (RoomEntity) o;
        return (roomEntity.name == this.name
                && roomEntity.rows == this.rows
                && roomEntity.columns == this.columns);
    }
}
