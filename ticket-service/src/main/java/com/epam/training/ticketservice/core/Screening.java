package com.epam.training.ticketservice.core;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Screening {
    private UUID id;
    private Movie movie;
    private Room room;
    private LocalDateTime startDate;

    public Screening(Movie movie, Room room, LocalDateTime startDate) {
        this.id = null;
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public Screening(UUID id, Movie movie, Room room, LocalDateTime startDate) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Screening screening = (Screening) o;
        return (screening.id == this.id
                && screening.movie == this.movie
                && screening.room == this.room
                && screening.startDate == this.startDate);
    }
}
