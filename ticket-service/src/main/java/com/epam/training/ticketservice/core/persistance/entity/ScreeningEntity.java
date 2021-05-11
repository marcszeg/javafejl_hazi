package com.epam.training.ticketservice.core.persistance.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
}
