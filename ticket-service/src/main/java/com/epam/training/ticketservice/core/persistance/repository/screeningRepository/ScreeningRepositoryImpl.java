package com.epam.training.ticketservice.core.persistance.repository.screeningRepository;

import com.epam.training.ticketservice.core.Room;
import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.dao.ScreeningDao;
import com.epam.training.ticketservice.core.persistance.entity.RoomEntity;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import com.epam.training.ticketservice.core.persistance.repository.roomRepository.RoomExceptionRoomNotFound;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ScreeningRepositoryImpl implements ScreeningRepository{

    private ScreeningDao screeningDao;
    private ScreeningMapper screeningMapper;

    public ScreeningRepositoryImpl(ScreeningDao screeningDao, ScreeningMapper screeningMapper) {
        this.screeningDao = screeningDao;
        this.screeningMapper = screeningMapper;
    }

    @Override
    public void createScreening(Screening screening) throws ScreeningExceptionScreeeningExists {
        if (isScreeningAlreadyExists(screening.getMovie().getTitle(), screening.getRoom().getName(), screening.getStartDate())) {
            throw new ScreeningExceptionScreeeningExists("This screening already exists");
        }
        screeningDao.save(screeningMapper.fromMapToScreeningEntity(screening));
    }

    private boolean isScreeningAlreadyExists(String movie, String room, Date startDate) {
        return screeningDao.findByIds(movie, room, startDate).isPresent();
    }

    @Override
    public void deleteScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound {
        if (!isScreeningAlreadyExists(movie, room, startDate)) {
            throw new ScreeningExceptionScreeningNotFound("Screening not found");
        }
        screeningDao.deleteByIds(movie, room, startDate);
    }

    @Override
    public Screening findScreening(String movie, String room, Date startDate) throws ScreeningExceptionScreeningNotFound {
        Optional<ScreeningEntity> screeningEntity = screeningDao.findByIds(movie, room, startDate);
        if (screeningEntity.isEmpty()){
            throw new ScreeningExceptionScreeningNotFound("Screening not found");
        }
        Optional<Screening> screening = fromMapToScreening(screeningEntity.get());
        return screening.get();
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningDao.findAll().stream().map(this::fromMapToScreening).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    private Optional<Screening> fromMapToScreening(ScreeningEntity screeningEntity) {
        Optional<Screening> result = Optional.empty();
        return result = Optional.of(screeningMapper.fromMapToScreening(screeningEntity));
    }
}
