package com.epam.training.ticketservice.core.persistance.entity;

import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ScreeningEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie")
    private MovieEntity movie;
    @Id
    @ManyToOne
    @JoinColumn(name = "room")
    private RoomEntity room;
    @Id
    private Date startDate;

    public ScreeningEntity(MovieEntity movie, RoomEntity room, Date startDate) {
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public ScreeningEntity() {
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
