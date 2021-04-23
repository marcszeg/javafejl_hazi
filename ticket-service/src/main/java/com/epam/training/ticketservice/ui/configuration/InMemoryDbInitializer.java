package com.epam.training.ticketservice.ui.configuration;

import com.epam.training.ticketservice.movie.repository.MovieRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class InMemoryDbInitializer {
    private MovieRepository movieRepository;

    public InMemoryDbInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}
