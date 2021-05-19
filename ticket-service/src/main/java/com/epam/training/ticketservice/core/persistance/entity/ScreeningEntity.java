package com.epam.training.ticketservice.core.persistance.entity;

import com.epam.training.ticketservice.core.Screening;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"movie", "room", "startDate"})})
public class ScreeningEntity {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "movie")
    private MovieEntity movie;
    @ManyToOne
    @JoinColumn(name = "room")
    private RoomEntity room;
    @Column(name = "startDate")
    private LocalDateTime startDate;

    public ScreeningEntity() {
    }

    public ScreeningEntity(MovieEntity movie, RoomEntity room, LocalDateTime startDate) {
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public ScreeningEntity(UUID id, MovieEntity movie, RoomEntity room, LocalDateTime startDate) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.startDate = startDate;
    }

    public UUID getId() {
        return id;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        ScreeningEntity screeningEntity = (ScreeningEntity) o;
        return (screeningEntity.id == this.id
                && movie.equals(screeningEntity.movie)
                && room.equals(screeningEntity.room)
                && screeningEntity.startDate == this.startDate);
    }
}
