package com.epam.training.ticketservice.core;

public class Movie {

    private String title;
    private String genre;
    private int length;

    public Movie(String title, String genre, int length) {
        this.title = title;
        this.genre = genre;
        this.length = length;
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

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Movie movie = (Movie) o;
        return (movie.title == this.title
                && movie.genre == this.genre
                && movie.length == this.length);
    }

}
