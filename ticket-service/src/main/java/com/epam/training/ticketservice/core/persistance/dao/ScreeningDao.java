package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface ScreeningDao extends JpaRepository<ScreeningEntity, UUID> {
    Optional<ScreeningEntity> findByMovieAndRoomAndStartDate(String movie, String room, LocalDateTime startDate);

    void deleteByMovieAndRoomAndStartDate(String movie, String room, LocalDateTime startDate);
}
