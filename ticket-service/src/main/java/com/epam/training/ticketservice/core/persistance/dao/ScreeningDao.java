package com.epam.training.ticketservice.core.persistance.dao;

import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ScreeningDao extends JpaRepository<ScreeningEntity, String> {
    Optional<ScreeningEntity> findByIds(String movie, String room, Date startDate);

    void deleteByIds(String movie, String room, Date startDate);
}
