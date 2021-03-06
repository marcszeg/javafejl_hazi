package com.epam.training.ticketservice.core.service.screeningservice;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieRepository;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomRepository;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningException;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository,
                                MovieRepository movieRepository, RoomRepository roomRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void createScreening(String movieTitle, String roomName, LocalDateTime startDate)
            throws ScreeningException, ScreeningExceptionOverlapping,
            ScreeningExceptionBreakOverlapping, MovieException, RoomException {
        Movie movie = findMovie(movieTitle);
        Room room = findRoom(roomName);
        if (areAnyOverlappingScreenings(startDate, startDate.plusMinutes(movie.getLength()), roomName)) {
            throw new ScreeningExceptionOverlapping("This is an overlapping screening");
        }
        if (areAnyOverlappingScreeningsWithBreak(startDate, startDate.plusMinutes(movie.getLength()), roomName)) {
            throw new ScreeningExceptionBreakOverlapping(
                    "This would start in the break period after another screening in this room");
        }
        screeningRepository.createScreening(new Screening(movie, room, startDate));
    }

    private Movie findMovie(String title) throws MovieException {
        return movieRepository.getMovie(title);
    }

    private Room findRoom(String name) throws RoomException {
        return roomRepository.getRoom(name);
    }

    private boolean areAnyOverlappingScreenings(LocalDateTime startDate, LocalDateTime screeningEnd, String room) {
        return screeningRepository.listScreenings().stream()
                .filter(screening -> screening.getRoom().getName().equals(room)).anyMatch(screening -> {
                    LocalDateTime currentScreeningStart = screening.getStartDate();
                    LocalDateTime currentScreeningEnd = screening.getStartDate()
                            .plusMinutes(screening.getMovie().getLength());
                    return isDatesInclusive(currentScreeningStart, currentScreeningEnd, startDate)
                            || isDatesInclusive(currentScreeningStart, currentScreeningEnd, screeningEnd);
                });
    }

    private boolean isDatesInclusive(LocalDateTime start, LocalDateTime end, LocalDateTime dateTimeToCheck) {
        return (dateTimeToCheck.isAfter(start) || dateTimeToCheck.isEqual(start))
                && (dateTimeToCheck.isBefore(end) || dateTimeToCheck.isEqual(end));
    }

    private boolean areAnyOverlappingScreeningsWithBreak(LocalDateTime startDate, LocalDateTime screeningEnd,
                                                         String room) {
        return screeningRepository.listScreenings().stream()
                .filter(screening -> screening.getRoom().getName().equals(room)).anyMatch(screening -> {
                    LocalDateTime currentScreeningStart = screening.getStartDate().minusMinutes(10);
                    LocalDateTime currentScreeningEnd = screening.getStartDate()
                            .plusMinutes(screening.getMovie().getLength()).plusMinutes(10);
                    return isDatesExclusive(currentScreeningStart, currentScreeningEnd, startDate)
                            || isDatesExclusive(currentScreeningStart, currentScreeningEnd, screeningEnd);
                });
    }

    private boolean isDatesExclusive(LocalDateTime start, LocalDateTime end, LocalDateTime dateTimeToCheck) {
        return dateTimeToCheck.isAfter(start) && dateTimeToCheck.isBefore(end);
    }

    @Override
    public void deleteScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException {
        screeningRepository.deleteScreeningByMovieTitleAndRoomNameAndStartDate(movie, room, startDate);
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningRepository.listScreenings();
    }
}
