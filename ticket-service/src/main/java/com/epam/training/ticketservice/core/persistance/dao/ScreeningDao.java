package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface ScreeningDao extends JpaRepository<ScreeningEntity, UUID> {
    Optional<ScreeningEntity> findByMovieTitleAndRoomNameAndStartDate(String movieTitle, String roomName,
                                                                      LocalDateTime startDate);

    void deleteByMovieTitleAndRoomNameAndStartDate(String movieTitle, String roomName, LocalDateTime startDate);
}
