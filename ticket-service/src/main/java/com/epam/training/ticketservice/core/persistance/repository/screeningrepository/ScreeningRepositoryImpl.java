package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.dao.ScreeningDao;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ScreeningRepositoryImpl implements ScreeningRepository {

    private ScreeningDao screeningDao;
    private ScreeningMapper screeningMapper;

    public ScreeningRepositoryImpl(ScreeningDao screeningDao, ScreeningMapper screeningMapper) {
        this.screeningDao = screeningDao;
        this.screeningMapper = screeningMapper;
    }

    @Override
    public void createScreening(Screening screening) throws ScreeningException {
        if (isScreeningAlreadyExists(screening.getMovie().getTitle(),
                screening.getRoom().getName(), screening.getStartDate())) {
            throw new ScreeningException("This screening already exists");
        }
        screeningDao.save(screeningMapper.fromScreeningToScreeningEntity(screening));
    }

    private boolean isScreeningAlreadyExists(String movie, String room, LocalDateTime startDate) {
        return screeningDao.findByMovieAndRoomAndStartDate(movie, room, startDate).isPresent();
    }

    @Override
    public void deleteScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException {
        if (!isScreeningAlreadyExists(movie, room, startDate)) {
            throw new ScreeningException("Screening not found");
        }
        screeningDao.deleteByMovieAndRoomAndStartDate(movie, room, startDate);
    }

    @Override
    public Screening findScreening(String movie, String room, LocalDateTime startDate) throws ScreeningException {
        Optional<ScreeningEntity> screeningEntity = screeningDao.findByMovieAndRoomAndStartDate(movie, room, startDate);
        if (screeningEntity.isEmpty()) {
            throw new ScreeningException("Screening not found");
        }
        Optional<Screening> screening = fromEntityToScreening(screeningEntity.get());
        return screening.get();
    }

    @Override
    public List<Screening> listScreenings() {
        return screeningDao.findAll().stream().map(this::fromEntityToScreening).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    private Optional<Screening> fromEntityToScreening(ScreeningEntity screeningEntity) {
        Optional<Screening> result = Optional.empty();
        return result = Optional.of(screeningMapper.fromScreeningEntityToScreening(screeningEntity));
    }
}
