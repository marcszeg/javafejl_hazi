package com.epam.training.ticketservice.core.persistance.repository.movierepository;

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
    public void createMovie(Movie movie) throws MovieException {
        if (isMovieAlreadyExists(movie.getTitle())) {
            throw new MovieException("This movie already exists.");
        }
        movieDao.save(movieMapper.fromMovieToMovieEntity(movie));
    }

    private boolean isMovieAlreadyExists(String title) {
        return movieDao.findById(title).isPresent();
    }

    @Override
    public void updateMovie(Movie movie) throws MovieException {
        if (!isMovieAlreadyExists(movie.getTitle())) {
            throw new MovieException("Movie not found");
        }
        MovieEntity updatedMovie = getMovieByTitle(movie.getTitle());
        updatedMovie.setGenre(movie.getGenre());
        updatedMovie.setLength(movie.getLength());

        movieDao.save(updatedMovie);
    }

    private MovieEntity getMovieByTitle(String title) throws MovieException {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        return movieEntity.get();
    }

    @Override
    public void deleteMovie(String title) throws MovieException {
        if (!isMovieAlreadyExists(title)) {
            throw new MovieException("Movie not found");
        }
        movieDao.deleteById(title);
    }

    @Override
    public List<Movie> listMovies() {
        return movieDao.findAll().stream().map(this::fromEntityToMovie)
                .filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
    }

    @Override
    public Movie getMovie(String title) throws MovieException {
        Optional<Movie> movie = fromEntityToMovie(getMovieEntity(title));
        if (movie.isEmpty()) {
            throw new MovieException("Movie not found");
        }
        return movie.get();
    }

    private Optional<Movie> fromEntityToMovie(MovieEntity movieEntity) {
        Optional<Movie> movie = Optional.empty();
        movie = Optional.of(movieMapper.fromMovieEntityToMovie(movieEntity));
        return movie;
    }

    private MovieEntity getMovieEntity(String title) throws MovieException {
        Optional<MovieEntity> movieEntity = movieDao.findById(title);
        if (movieEntity.isEmpty()) {
            throw new MovieException("Movie not found");
        }
        return movieEntity.get();
    }


}
