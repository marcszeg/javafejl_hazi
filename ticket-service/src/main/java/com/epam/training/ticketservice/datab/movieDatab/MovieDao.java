package com.epam.training.ticketservice.datab.movieDatab;

import com.epam.training.ticketservice.datab.movieDatab.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<MovieEntity, String> {
}
