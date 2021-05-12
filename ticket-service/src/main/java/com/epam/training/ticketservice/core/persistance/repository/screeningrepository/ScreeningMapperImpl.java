package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieMapper;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomMapper;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapperImpl implements ScreeningMapper {

    private MovieMapper movieMapper;
    private RoomMapper roomMapper;

    public ScreeningMapperImpl(MovieMapper movieMapper, RoomMapper roomMapper) {
        this.movieMapper = movieMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public Screening fromScreeningEntityToScreening(ScreeningEntity screeningEntity) {
        return new Screening(screeningEntity.getId(),
                movieMapper.fromMovieEntityToMovie(screeningEntity.getMovie()),
                roomMapper.fromRoomEntityToRoom(screeningEntity.getRoom()),
                screeningEntity.getStartDate());
    }

    @Override
    public ScreeningEntity fromScreeningToScreeningEntity(Screening screening) {
        if (screening.getId() == null) {
            return new ScreeningEntity(movieMapper.fromMovieToMovieEntity(screening.getMovie()),
                    roomMapper.fromRoomToRoomEntity(screening.getRoom()),
                    screening.getStartDate());
        } else {
            return new ScreeningEntity(screening.getId(),
                    movieMapper.fromMovieToMovieEntity(screening.getMovie()),
                    roomMapper.fromRoomToRoomEntity(screening.getRoom()),
                    screening.getStartDate());
        }
    }
}
