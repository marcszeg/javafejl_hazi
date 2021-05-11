package com.epam.training.ticketservice.core;

import java.util.Date;
import java.util.UUID;

public class Screening {
    private UUID id;
    private Movie movie;
    private Room room;
    private Date startDate;

    public Screening(Movie movie, Room room, Date startDate) {
        this.id = null;
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public Screening(UUID id, Movie movie, Room room, Date startDate) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public UUID getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }
}
