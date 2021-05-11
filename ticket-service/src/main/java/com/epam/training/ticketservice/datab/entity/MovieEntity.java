package com.epam.training.ticketservice.datab.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieEntity {
    @Id
    private String title;
    private String genre;
    private int length;


    public MovieEntity(String title, String genre, int length) {
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    public MovieEntity() {
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
