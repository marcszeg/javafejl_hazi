package com.epam.training.ticketservice.ui.configuration;

import com.epam.training.ticketservice.movie.entity.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Movie movie(){
        return new Movie();
    }
}
