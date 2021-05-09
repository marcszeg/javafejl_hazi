package com.epam.training.ticketservice.controller;

import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;
import com.epam.training.ticketservice.service.MovieService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class MovieController {
    private MovieService movieService;
    //private String noMovies = "There are no movies at the moment";
    //private String movieListingFormat = "%s (%s, %d minutes)";

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @ShellMethod(key = "create movie")
    public String createMovie(String title, String genre, int length){
        String answer;
        try {
            movieService.createMovie(title, genre, length);
            answer = "Movie created";
        } catch (MovieExistsException exception){
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(key = "update movie")
    public String updateMovie(String title, String genre, int length){
        String answer;
        try {
            movieService.updateMovie(title, genre, length);
            answer = "Movie updated";
        } catch (MovieNotFoundException exception){
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(key = "delete movie")
    public String deleteMovie(String title){
        String answer;
        try {
            movieService.deleteMovie(title);
            answer = "Movie deleted";
        } catch (MovieNotFoundException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    public String listMovies(){
        List<Movie> movies = movieService.listMovies();
        return movies.isEmpty() ? "There are no movies at the moment"
                : movies.stream().map(this::mapToStringMovie)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String mapToStringMovie(Movie movie) {
        return String.format("%s (%s, %d minutes)", movie.getTitle(),movie.getGenre(), movie.getLength());
    }

}

