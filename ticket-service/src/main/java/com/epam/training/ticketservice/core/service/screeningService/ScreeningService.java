package com.epam.training.ticketservice.core.service.screeningService;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieExceptionMovieNotFound;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomNotFound;
import com.epam.training.ticketservice.core.persistance.repository.screeningRepository.ScreeningExceptionScreeeningExists;
import com.epam.training.ticketservice.core.persistance.repository.screeningRepository.ScreeningExceptionScreeningNotFound;

import java.util.Date;
import java.util.List;

public interface ScreeningService {
    void createScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeeningExists,
            ScreeningExceptionOverlapping, ScreeningExceptionBreakOverlapping, MovieExceptionMovieNotFound,
            RoomExceptionRoomNotFound;

    void deleteScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound;

    List<Screening> listScreenings();
}
