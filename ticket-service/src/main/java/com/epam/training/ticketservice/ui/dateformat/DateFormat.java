package com.epam.training.ticketservice.ui.dateformat;

import java.time.LocalDateTime;

public interface DateFormat {
    LocalDateTime fromMapToLocalDateTime(String startDate, String stringFormat);

    String toString(LocalDateTime startDate, String stringFormat);
}
