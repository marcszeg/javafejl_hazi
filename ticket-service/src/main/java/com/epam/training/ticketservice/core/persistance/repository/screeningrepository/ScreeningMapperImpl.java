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
    public Screening fromMapToScreening(ScreeningEntity screeningEntity) {
        return new Screening(screeningEntity.getId(),
                movieMapper.fromMapToMovie(screeningEntity.getMovie()),
                roomMapper.fromMapToRoom(screeningEntity.getRoom()),
                screeningEntity.getStartDate());
    }

    @Override
    public ScreeningEntity fromMapToScreeningEntity(Screening screening) {
        if (screening.getId().equals(null)) {
            return new ScreeningEntity(movieMapper.fromMapToMovieEntity(screening.getMovie()),
                    roomMapper.fromMapToRoomEntity(screening.getRoom()),
                    screening.getStartDate());
        } else {
            return new ScreeningEntity(screening.getId(),
                    movieMapper.fromMapToMovieEntity(screening.getMovie()),
                    roomMapper.fromMapToRoomEntity(screening.getRoom()),
                    screening.getStartDate());
        }
    }
}
