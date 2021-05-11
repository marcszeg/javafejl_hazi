package com.epam.training.ticketservice.core.persistance.repository.screeningrepository;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.entity.ScreeningEntity;

public interface ScreeningMapper {
    Screening fromMapToScreening(ScreeningEntity screeningEntity);

    ScreeningEntity fromMapToScreeningEntity(Screening screening);
}
