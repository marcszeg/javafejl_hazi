package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<MovieEntity, String> {
}
