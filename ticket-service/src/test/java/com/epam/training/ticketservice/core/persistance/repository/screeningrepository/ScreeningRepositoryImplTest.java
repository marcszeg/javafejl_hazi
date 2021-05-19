package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.dao.ScreeningDao;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningRepositoryImplTest {
    private ScreeningRepositoryImpl screeningRepositoryUnderTest;
    private ScreeningDao screeningDao;
    private ScreeningMapper screeningMapper;

    private static final String MOVIE_TITLE = "title";
    private static final String ROOM_NAME = "room";
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final Movie MOVIE = new Movie(MOVIE_TITLE, "genre", 90);
    private static final MovieEntity MOVIE_ENTITY = new MovieEntity(MOVIE_TITLE, "genre", 90);
    private static final Room ROOM = new Room(ROOM_NAME, 20, 20);
    private static final RoomEntity ROOM_ENTITY = new RoomEntity(ROOM_NAME, 20, 20);
    private static final Screening SCREENING = new Screening(MOVIE, ROOM, START_DATE);
    private static final ScreeningEntity SCREENING_ENTITY = new ScreeningEntity(MOVIE_ENTITY, ROOM_ENTITY, START_DATE);

    @BeforeEach
    public void init() {
        screeningDao = Mockito.mock(ScreeningDao.class);
        screeningMapper = Mockito.mock(ScreeningMapper.class);
        screeningRepositoryUnderTest = new ScreeningRepositoryImpl(screeningDao, screeningMapper);
    }

    @Test
    void testCreateScreeningShouldCreateScreening() throws ScreeningException {
        Mockito.when(screeningDao.findByMovieTitleAndRoomNameAndStartDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Optional.empty());
        Mockito.when(screeningMapper.fromScreeningToScreeningEntity(Mockito.any())).thenReturn(SCREENING_ENTITY);

        //When
        screeningRepositoryUnderTest.createScreening(SCREENING);

        //Then
        Mockito.verify(screeningDao, Mockito.times(1)).save(SCREENING_ENTITY);
    }

    @Test
    void testCreateScreeningShouldThrowError() throws ScreeningException {
        //Given
        Mockito.when(screeningDao.findByMovieTitleAndRoomNameAndStartDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Optional.of(SCREENING_ENTITY));

        //Then
        assertThrows(ScreeningException.class, () -> {
            screeningRepositoryUnderTest.createScreening(SCREENING);
        });
    }

    @Test
    void testDeleteScreeningShouldDeleteScreening() throws ScreeningException {
        //Given
        Mockito.when(screeningDao.findByMovieTitleAndRoomNameAndStartDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Optional.of(SCREENING_ENTITY));

        //When
        screeningRepositoryUnderTest
                .deleteScreeningByMovieTitleAndRoomNameAndStartDate(MOVIE_TITLE, ROOM_NAME, START_DATE);

        //Then
        Mockito.verify(screeningDao, Mockito.times(1))
                .deleteByMovieTitleAndRoomNameAndStartDate(MOVIE_TITLE, ROOM_NAME, START_DATE);
    }

    @Test
    void testDeleteScreeningShouldThrowError() throws ScreeningException {
        //Given
        Mockito.when(screeningDao.findByMovieTitleAndRoomNameAndStartDate(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(Optional.empty());

        //Then
        assertThrows(ScreeningException.class, () -> {
            screeningRepositoryUnderTest.deleteScreeningByMovieTitleAndRoomNameAndStartDate(MOVIE_TITLE, ROOM_NAME, START_DATE);
        });
    }

}