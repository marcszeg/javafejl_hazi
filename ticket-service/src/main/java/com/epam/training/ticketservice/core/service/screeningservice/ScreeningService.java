package com.epam.training.ticketservice.core.service.screeningservice;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningException;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {
    void createScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException,
            ScreeningExceptionOverlapping, ScreeningExceptionBreakOverlapping, MovieException,
            RoomException;

    void deleteScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException;

    List<Screening> listScreenings();
}
