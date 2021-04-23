package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.movie.MovieService;
import com.epam.training.ticketservice.movie.model.MovieDto;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.List;

@ShellComponent
public class MovieCommand {
    private final MovieService movieService;

    public MovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @ShellMethod(value = "List all movies", key = "list movies")
    public List<MovieDto> listMoviesOnShel() {
        return movieService.getMovieList();
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(value = "Admin create Movie", key = "create movie")
    public MovieDto createMovie(String title, String genre, int length) {
        MovieDto movie = new MovieDto.Builder()
                .withTitle(title)
                .withGenre(genre)
                .withLength(length)
                .build();
        movieService.createMovie(movie);
        return movie;
    }
}
