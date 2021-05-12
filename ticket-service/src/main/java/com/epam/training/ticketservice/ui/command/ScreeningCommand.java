package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningException;
import com.epam.training.ticketservice.core.service.screeningservice.ScreeningExceptionBreakOverlapping;
import com.epam.training.ticketservice.core.service.screeningservice.ScreeningExceptionOverlapping;
import com.epam.training.ticketservice.core.service.screeningservice.ScreeningService;
import com.epam.training.ticketservice.ui.AdminMethodCheck;
import com.epam.training.ticketservice.ui.dateformat.DateFormat;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class ScreeningCommand {

    private ScreeningService screeningService;
    private AdminMethodCheck adminMethodCheck;
    private DateFormat dateFormat;

    public ScreeningCommand(ScreeningService screeningService,
                            AdminMethodCheck adminMethodCheck, DateFormat dateFormat) {
        this.screeningService = screeningService;
        this.adminMethodCheck = adminMethodCheck;
        this.dateFormat = dateFormat;
    }

    public Availability isAdminSignedIn() {
        return adminMethodCheck.isAdminSignedIn();
    }

    @ShellMethod(value = "Creates a screening", key = "create screening")
    @ShellMethodAvailability("isAdminSignedIn")
    public String createScreening(String movie, String room, String startDate) {
        String answer;
        try {
            screeningService.createScreening(movie, room,
                    dateFormat.fromMapToLocalDateTime(startDate, "yyyy-MM-dd HH:mm"));
            answer = "Screening crated";
        } catch (ScreeningException | MovieException | RoomException exception) {
            answer = exception.getMessage();
        } catch (ScreeningExceptionOverlapping exception) {
            answer = exception.getMessage();
        } catch (ScreeningExceptionBreakOverlapping exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Deletes a screening", key = "delete screening")
    @ShellMethodAvailability("isAdminSignedIn")
    public String deleteScreening(String movie, String room, String startDate) {
        String answer;
        try {
            screeningService.deleteScreening(movie, room,
                    dateFormat.fromMapToLocalDateTime(startDate, "yyyy-MM-dd HH:mm"));
            answer = "Screening deleted";
        } catch (ScreeningException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    @ShellMethod(value = "Lists screenings", key = "list screenings")
    public String listScreenings() {
        String answer;
        List<Screening> screenings = screeningService.listScreenings();
        if (screenings.isEmpty()) {
            answer = "There are no screenings";
        } else {
            answer = screenings.stream().map(this::mapToStringScreening)
                    .collect(Collectors.joining(System.lineSeparator()));
        }
        return answer;
    }

    private String mapToStringScreening(Screening screening) {
        return String.format("%s (%s, %d minutes), screened in room %s, at %s", screening.getMovie().getTitle(),
                screening.getMovie().getGenre(), screening.getMovie().getLength(), screening.getRoom().getName(),
                dateFormat.toString(screening.getStartDate(), "yyyy-MM-dd HH:mm"));
    }

}
