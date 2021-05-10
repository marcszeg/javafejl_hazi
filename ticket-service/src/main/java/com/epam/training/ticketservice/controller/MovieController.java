package com.epam.training.ticketservice.controller;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class MovieController {
    private MovieService movieService;
    private AdminMethodCheck adminMethodCheck;

    public MovieController(MovieService movieService, AdminMethodCheck adminMethodCheck) {
        this.movieService = movieService;
        this.adminMethodCheck = adminMethodCheck;
    }

    public Availability isAdminSignedIn() {
        return adminMethodCheck.isAdminSignedIn();
    }

    @ShellMethod(value = "Create a movie", key = "create movie")
    @ShellMethodAvailability("isAdminSignedIn")
    public String createMovie(String title, String genre, int length) {
        String answer;
        try {
            movieService.createMovie(title, genre, length);
            answer = "Movie created";
        } catch (MovieExistsException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Update a movie", key = "update movie")
    @ShellMethodAvailability("isAdminSignedIn")
    public String updateMovie(String title, String genre, int length) {
        String answer;
        try {
            movieService.updateMovie(title, genre, length);
            answer = "Movie updated";
        } catch (MovieNotFoundException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Delete a movie", key = "delete movie")
    @ShellMethodAvailability("isAdminSignedIn")
    public String deleteMovie(String title) {
        String answer;
        try {
            movieService.deleteMovie(title);
            answer = "Movie deleted";
        } catch (MovieNotFoundException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "List all movies", key = "list movies")
    public String listMovies() {
        List<Movie> movies = movieService.listMovies();
        return movies.isEmpty() ? "There are no movies at the moment"
                : movies.stream().map(this::mapToStringMovie)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String mapToStringMovie(Movie movie) {
        return String.format("%s (%s, %d minutes)", movie.getTitle(),movie.getGenre(), movie.getLength());
    }

}

