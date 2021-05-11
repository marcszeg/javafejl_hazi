package com.epam.training.ticketservice.datab;

import com.epam.training.ticketservice.datab.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<MovieEntity, String> {
}
