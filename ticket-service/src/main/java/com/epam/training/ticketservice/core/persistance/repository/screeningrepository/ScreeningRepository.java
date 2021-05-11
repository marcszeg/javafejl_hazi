package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

import com.epam.training.ticketservice.core.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository {
    void createScreening(Screening screening) throws ScreeningException;

    List<Screening> listScreenings();

    void deleteScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException;

    Screening findScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException;
}
