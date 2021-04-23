package com.epam.training.ticketservice.movie.impl;

import com.epam.training.ticketservice.movie.MovieService;
import com.epam.training.ticketservice.movie.entity.Movie;
import com.epam.training.ticketservice.movie.model.MovieDto;
import com.epam.training.ticketservice.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getMovieList() {
        return movieRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDto> getMovieByTitle(String movieTitle) {
        return convertEntityToDto(movieRepository.findByTitle(movieTitle));
    }

    @Override
    public void createMovie(MovieDto movieDto) {
        Objects.requireNonNull(movieDto, "Movie cannot be null");
        Objects.requireNonNull(movieDto.getTitle(), "Movie title cannot be null");
        Objects.requireNonNull(movieDto.getGenre(), "Movie genre cannot be null");
        Objects.requireNonNull(movieDto.getLength(), "Movie length cannot be null");
        Movie movie = new Movie(null, movieDto.getTitle(), movieDto.getGenre(), movieDto.getLength());
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    /*@Override
    public void updateMovie(Movie movie) {
        Optional<Movie> updatedMovie = movieRepository.findById(movie.getId());

    }*/

    private Optional<MovieDto> convertEntityToDto(Optional<Movie> movie) {
        Optional<MovieDto> movieDto;
        if(movie.isEmpty()) {
            movieDto = Optional.empty();
        } else {
            movieDto = Optional.of(convertEntityToDto(movie.get()));
        }
        return movieDto;
    }

    private MovieDto convertEntityToDto(Movie movie) {
        return new MovieDto.Builder()
                .withTitle(movie.getTitle())
                .withGenre(movie.getGenre())
                .withLength(movie.getLength())
                .build();
    }
}
