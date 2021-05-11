package com.epam.training.ticketservice.core.persistance.repository.screeningRepository;

import com.epam.training.ticketservice.core.Screening;

import java.util.Date;
import java.util.List;

public interface ScreeningRepository {
    void createScreening(Screening screening) throws ScreeningExceptionScreeeningExists;

    List<Screening> listScreenings();

    void deleteScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound;

    Screening findScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound;
}
