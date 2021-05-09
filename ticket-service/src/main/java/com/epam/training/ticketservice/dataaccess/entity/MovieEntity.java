package com.epam.training.ticketservice.dataaccess.entity;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        this.length = length;
    }
}