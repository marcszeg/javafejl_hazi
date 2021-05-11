package com.epam.training.ticketservice.core.persistance.repository.screeningRepository;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import com.epam.training.ticketservice.core.persistance.repository.movieRepository.MovieMapper;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomMapper;
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
        return new Screening(movieMapper.fromMapToMovie(screeningEntity.getMovie()),
                roomMapper.fromMapToRoom(screeningEntity.getRoom()),
                screeningEntity.getStartDate());
    }

    @Override
    public ScreeningEntity fromMapToScreeningEntity(Screening screening) {
        return new ScreeningEntity(movieMapper.fromMapToMovieEntity(screening.getMovie()),
                roomMapper.fromMapToRoomEntity(screening.getRoom()),
                screening.getStartDate());
    }
}
