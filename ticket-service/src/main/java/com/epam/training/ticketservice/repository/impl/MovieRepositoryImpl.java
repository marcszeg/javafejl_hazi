package com.epam.training.ticketservice.repository.impl;

import com.epam.training.ticketservice.dataaccess.MovieDao;
import com.epam.training.ticketservice.dataaccess.entity.MovieEntity;
import com.epam.training.ticketservice.domain.Movie;
import com.epam.training.ticketservice.repository.MovieRepository;
import com.epam.training.ticketservice.repository.exception.MovieExistsException;
import com.epam.training.ticketservice.repository.exception.MovieNotFoundException;
import com.epam.training.ticketservice.repository.map.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private MovieDao movieDao;
    private MovieMapper movieMapper;

    @Override
    public void createMovie(Movie movie) throws MovieExistsException {
        if(isMovieAlreadyExists(movie.getTitle())){
            throw new MovieExistsException(String.format("This movie already exists."));
        }
        movieDao.save(movieMapper.fromMapToEntityMovie(movie));
    }

    private boolean isMovieAlreadyExists(String title) {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        return movieEntity.isPresent();
    }

    @Override
    public void updateMovie(Movie movie) throws MovieNotFoundException {
        if(!isMovieAlreadyExists(movie.getTitle())){
            throw new MovieNotFoundException(String.format("Movie not found!"));
        }
        MovieEntity updatedMovie = getMovieByTitle(movie.getTitle());
        updatedMovie.setGenre(movie.getGenre());
        updatedMovie.setLength(movie.getLength());

        movieDao.save(updatedMovie);
    }

    private MovieEntity getMovieByTitle(String title) throws MovieNotFoundException {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        return movieEntity.get();
    }

    @Override
    public void deleteMovie(String title) throws MovieNotFoundException {
        if(!isMovieAlreadyExists(title)){
            throw new MovieNotFoundException(String.format("Movie not found!"));
        }
        movieDao.deleteById(title);
    }

    @Override
    public List<Movie> listMovies() {
        return null;
    }




}
