package com.epam.training.ticketservice.core.persistance.repository.movierepository;

import com.epam.training.ticketservice.core.Movie;
import com.epam.training.ticketservice.core.persistance.dao.MovieDao;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;

class MovieRepositoryImplTest {

    private MovieRepositoryImpl movieRepositoryUnderTest;
    private MovieDao movieDao;
    private MovieMapper movieMapper;

    private static final String DEADPOOL = "Deadpool";
    private static final String SNATCH = "Snatch";
    private static final String GENRE = "action";
    private static final int LENGTH = 90;
    private static final int LENGTH_UPDATE = 104;
    private static final Movie DEADPOOL_MOVIE = new Movie(DEADPOOL, GENRE, LENGTH);
    private static final Movie DEADPOOL_MOVIE_UPDATE = new Movie(DEADPOOL, GENRE, LENGTH_UPDATE);
    private static final Movie SNATCH_MOVIE = new Movie(SNATCH, GENRE, LENGTH);
    private static final MovieEntity DEADPOOL_MOVIE_ENTITY = new MovieEntity(DEADPOOL, GENRE, LENGTH);
    private static final MovieEntity DEADPOOL_MOVIE_ENTITY_UPDATE = new MovieEntity(DEADPOOL, GENRE, LENGTH_UPDATE);
    private static final MovieEntity SNATCH_MOVIE_ENTITY = new MovieEntity(SNATCH, GENRE, LENGTH);
    private static final List<Movie> MOVIE_LIST = List.of(SNATCH_MOVIE, SNATCH_MOVIE);
    private static final List<MovieEntity> MOVIE_ENTITY_LIST = List.of(SNATCH_MOVIE_ENTITY, SNATCH_MOVIE_ENTITY);

    @BeforeEach
    public void init() {
        movieDao = Mockito.mock(MovieDao.class);
        movieMapper = Mockito.mock(MovieMapper.class);
        movieRepositoryUnderTest = new MovieRepositoryImpl(movieDao, movieMapper);
    }

    @Test
    void testCreateMovieShouldCreateGivenMovie() throws MovieException {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(movieMapper.fromMovieToMovieEntity(Mockito.any())).thenReturn(SNATCH_MOVIE_ENTITY);

        //When
        movieRepositoryUnderTest.createMovie(SNATCH_MOVIE);

        //Then
        Mockito.verify(movieDao, Mockito.times(1)).save(SNATCH_MOVIE_ENTITY);
    }

    @Test
    void testCreateMovieShouldThrowError() throws MovieException {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.of(SNATCH_MOVIE_ENTITY));

        //Then
        assertThrows(MovieException.class, () -> {
            movieRepositoryUnderTest.createMovie(SNATCH_MOVIE);
        });
    }

    @Test
    void testListAllMoviesShouldListAllMovies() throws MovieException {
        //Given
        Mockito.when(movieDao.findAll()).thenReturn(MOVIE_ENTITY_LIST);
        Mockito.when(movieMapper.fromMovieEntityToMovie(Mockito.any())).thenReturn(SNATCH_MOVIE);

        //When
        List<Movie> actual = movieRepositoryUnderTest.listMovies();

        //Then
        Assertions.assertEquals(MOVIE_LIST, actual);
    }

    @Test
    void testDeleteMovieShouldDeleteGivenMovie() throws MovieException  {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.of(SNATCH_MOVIE_ENTITY));

        //When
        movieRepositoryUnderTest.deleteMovie(SNATCH);

        //Then
        Mockito.verify(movieDao, Mockito.times(1)).deleteById(SNATCH);
    }

    @Test
    void testDeleteMovieShouldThrowError() throws MovieException {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.empty());

        //Then
        assertThrows(MovieException.class, () -> {
            movieRepositoryUnderTest.deleteMovie(SNATCH);
        });
    }

    @Test
    void testUpdateMovieShouldUpdateMovie() throws MovieException {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.of(DEADPOOL_MOVIE_ENTITY));

        //When
        movieRepositoryUnderTest.updateMovie(DEADPOOL_MOVIE_UPDATE);

        //Then
        Mockito.verify(movieDao, Mockito.times(1)).save(DEADPOOL_MOVIE_ENTITY_UPDATE);

    }

    @Test
    void testUpdateMovieShouldThrowError() throws MovieException {
        //Given
        Mockito.when(movieDao.findById(Mockito.any())).thenReturn(Optional.empty());

        //Then
        assertThrows(MovieException.class, () -> {
            movieRepositoryUnderTest.updateMovie(DEADPOOL_MOVIE_UPDATE);
        });
    }

}