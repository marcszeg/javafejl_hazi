package com.epam.training.ticketservice.ui.dateformat;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateFormatImpl implements DateFormat {
    @Override
    public LocalDateTime fromMapToLocalDateTime(String startDate, String stringFormat) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(stringFormat);
        return LocalDateTime.parse(startDate, dateTimeFormat);
    }

    @Override
    public String toString(LocalDateTime startDate, String stringFormat) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(stringFormat);
        return startDate.format(dateTimeFormat);
    }
}
