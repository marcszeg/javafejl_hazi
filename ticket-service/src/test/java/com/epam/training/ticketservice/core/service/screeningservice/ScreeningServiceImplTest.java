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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningServiceImplTest {

    private ScreeningServiceImpl screeningServiceUnderTest;
    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;

    private static final String MOVIE_TITLE = "movie";
    private static final String ROOM_NAME = "room";
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final LocalDateTime START_DATE_OTHER = START_DATE.plusMinutes(300);
    private static final LocalDateTime START_DATE_OVERLAP = START_DATE.plusMinutes(60);
    private static final LocalDateTime START_DATE_BREAK_OVERLAP = START_DATE.plusMinutes(115);
    private static final Movie MOVIE = new Movie(MOVIE_TITLE, "genre", 110);
    private static final Room ROOM = new Room(ROOM_NAME, 20, 20);
    private static final Screening SCREENING = new Screening(MOVIE, ROOM, START_DATE);
    private static final Screening SCREENING_OTHER = new Screening(MOVIE, ROOM, START_DATE_OTHER);
    private static final List<Screening> SCREENING_LIST = List.of(SCREENING);

    @BeforeEach
    public void init() {
        screeningRepository = Mockito.mock(ScreeningRepository.class);
        movieRepository = Mockito.mock(MovieRepository.class);
        roomRepository = Mockito.mock(RoomRepository.class);
        screeningServiceUnderTest = new ScreeningServiceImpl(screeningRepository, movieRepository, roomRepository);
    }

    @Test
    void testCreateScreeningShouldCreateScreening() throws ScreeningException, ScreeningExceptionOverlapping,
            ScreeningExceptionBreakOverlapping, RoomException, MovieException {
        //Given
        Mockito.when(movieRepository.getMovie(Mockito.any())).thenReturn(MOVIE);
        Mockito.when(roomRepository.getRoom(Mockito.any())).thenReturn(ROOM);
        Mockito.when(screeningRepository.listScreenings()).thenReturn(SCREENING_LIST);

        //When
        screeningServiceUnderTest.createScreening(MOVIE_TITLE, ROOM_NAME, START_DATE_OTHER);

        //Then
        Mockito.verify(screeningRepository, Mockito.times(1)).createScreening(SCREENING_OTHER);
    }

    @Test
    void testCreateScreeningShouldThrowOverlappingError() throws ScreeningException, ScreeningExceptionOverlapping,
            ScreeningExceptionBreakOverlapping, MovieException, RoomException {
        //Given
        Mockito.when(movieRepository.getMovie(Mockito.any())).thenReturn(MOVIE);
        Mockito.when(roomRepository.getRoom(Mockito.any())).thenReturn(ROOM);
        Mockito.when(screeningRepository.listScreenings()).thenReturn(SCREENING_LIST);

        assertThrows(ScreeningExceptionOverlapping.class, () -> {
            screeningServiceUnderTest.createScreening(MOVIE_TITLE, ROOM_NAME, START_DATE_OVERLAP);
        });
    }

    @Test
    void testCreateScreeningShouldThrowBreakOverlappingError() throws ScreeningException, ScreeningExceptionOverlapping,
            ScreeningExceptionBreakOverlapping, MovieException, RoomException {
        //Given
        Mockito.when(movieRepository.getMovie(Mockito.any())).thenReturn(MOVIE);
        Mockito.when(roomRepository.getRoom(Mockito.any())).thenReturn(ROOM);
        Mockito.when(screeningRepository.listScreenings()).thenReturn(SCREENING_LIST);

        assertThrows(ScreeningExceptionBreakOverlapping.class, () -> {
            screeningServiceUnderTest.createScreening(MOVIE_TITLE, ROOM_NAME, START_DATE_BREAK_OVERLAP);
        });
    }

}