package com.epam.training.ticketservice.core;

import java.util.Date;

public class Screening {
    private Movie movie;
    private Room room;
    private Date startDate;

    public Screening(Movie movie, Room room, Date startDate) {
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
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
