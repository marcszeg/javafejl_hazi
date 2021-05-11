package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<MovieEntity, String> {
}
