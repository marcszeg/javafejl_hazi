package com.epam.training.ticketservice.core.service.screeningService;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.dao.ScreeningDao;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomRepository;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningException;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService{

    private ScreeningDao screeningDao;
    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;

    @Override
    public void createScreening(String movieTitle, String roomName, LocalDateTime startDate) throws ScreeningException, ScreeningExceptionOverlapping, ScreeningExceptionBreakOverlapping, MovieException, RoomException {
        Movie movie = movieRepository.getMovie(movieTitle);
        Room room = roomRepository.getRoom(roomName);
        //TO DO
        screeningRepository.createScreening(new Screening(movie, room, startDate));
    }



    @Override
    public void deleteScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException {
        /*if (screeningRepository.findScreening(movie, room, startDate).isPresent) {

        }*/
        screeningRepository.deleteScreening(movie, room, startDate);
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningRepository.listScreenings();
    }
}
