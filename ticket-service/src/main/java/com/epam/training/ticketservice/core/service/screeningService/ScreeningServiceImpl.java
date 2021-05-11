package com.epam.training.ticketservice.core.service.screeningService;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieExceptionMovieNotFound;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomNotFound;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomRepository;
import com.epam.training.ticketservice.core.persistance.repository.screeningRepository.ScreeningExceptionScreeeningExists;
import com.epam.training.ticketservice.core.persistance.repository.screeningRepository.ScreeningExceptionScreeningNotFound;
import com.epam.training.ticketservice.core.persistance.repository.screeningRepository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService{

    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;

    @Override
    public void createScreening(String movieTitle, String roomName, Date startDate) throws ScreeningExceptionScreeeningExists, ScreeningExceptionOverlapping, ScreeningExceptionBreakOverlapping, MovieExceptionMovieNotFound, RoomExceptionRoomNotFound {
        Movie movie = movieRepository.getMovie(movieTitle);
        Room room = roomRepository.getRoom(roomName);
        //TO DO
        screeningRepository.createScreening(new Screening(movie, room, startDate));
    }

    @Override
    public void deleteScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound {
        /*if (screeningRepository.findScreening(movie, room, startDate).isPresent) {

        }*/
        screeningRepository.deleteScreening(movie, room, startDate);
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningRepository.listScreenings();
    }
}
