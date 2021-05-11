package com.epam.training.ticketservice.core.persistance.repository.movieRepository;

import com.epam.training.ticketservice.core.persistance.dao.MovieDao;
import com.epam.training.ticketservice.core.persistance.entity.MovieEntity;
import com.epam.training.ticketservice.core.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private MovieDao movieDao;
    private MovieMapper movieMapper;

    public MovieRepositoryImpl(MovieDao movieDao, MovieMapper movieMapper) {
        this.movieDao = movieDao;
        this.movieMapper = movieMapper;
    }

    @Override
    public void createMovie(Movie movie) throws MovieExceptionMovieExists {
        if (isMovieAlreadyExists(movie.getTitle())) {
            throw new MovieExceptionMovieExists("This movie already exists.");
        }
        movieDao.save(movieMapper.fromMapToMovieEntity(movie));
    }

    private boolean isMovieAlreadyExists(String title) {
        return movieDao.findById(title).isPresent();
    }

    @Override
    public void updateMovie(Movie movie) throws MovieExceptionMovieNotFound {
        if (!isMovieAlreadyExists(movie.getTitle())) {
            throw new MovieExceptionMovieNotFound("Movie not found");
        }
        MovieEntity updatedMovie = getMovieByTitle(movie.getTitle());
        updatedMovie.setGenre(movie.getGenre());
        updatedMovie.setLength(movie.getLength());

        movieDao.save(updatedMovie);
    }

    private MovieEntity getMovieByTitle(String title) throws MovieExceptionMovieNotFound {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        return movieEntity.get();
    }

    @Override
    public void deleteMovie(String title) throws MovieExceptionMovieNotFound {
        if (!isMovieAlreadyExists(title)) {
            throw new MovieExceptionMovieNotFound("Movie not found");
        }
        movieDao.deleteById(title);
    }

    @Override
    public List<Movie> listMovies() {
        return movieDao.findAll().stream().map(this::fromMapToMovie)
                .filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    @Override
    public Movie getMovie(String title) throws MovieExceptionMovieNotFound {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        if (movieEntity.isEmpty()){
            throw new MovieExceptionMovieNotFound("Movie not found");
        }
        Optional<Movie> movie = fromMapToMovie(movieEntity.get());
        return movie.get();
    }

    private Optional<Movie> fromMapToMovie(MovieEntity movieEntity) {
        Optional<Movie> result = Optional.empty();
        return result = Optional.of(movieMapper.fromMapToMovie(movieEntity));
    }


}
