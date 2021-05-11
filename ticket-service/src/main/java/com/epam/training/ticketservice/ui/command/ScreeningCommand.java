package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.Screening;
import com.epam.training.ticketservice.core.persistance.repository.movierepository.MovieException;
import com.epam.training.ticketservice.core.persistance.repository.roomrepository.RoomException;
import com.epam.training.ticketservice.core.persistance.repository.screeningrepository.ScreeningException;
import com.epam.training.ticketservice.core.service.screeningService.ScreeningExceptionBreakOverlapping;
import com.epam.training.ticketservice.core.service.screeningService.ScreeningExceptionOverlapping;
import com.epam.training.ticketservice.core.service.screeningService.ScreeningService;
import com.epam.training.ticketservice.ui.AdminMethodCheck;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class ScreeningCommand {

    private ScreeningService screeningService;
    private AdminMethodCheck adminMethodCheck;

    public Availability isAdminSignedIn() {
        return adminMethodCheck.isAdminSignedIn();
    }

    @ShellMethod(value = "Creates a screening", key = "create screening")
    @ShellMethodAvailability("isAdminSignedIn")
    public String createScreening(String movie, String room, LocalDateTime startDate) {
        String answer = null;
        try {
            screeningService.createScreening(movie, room, startDate);
            answer = "Screening crated";
        } catch (ScreeningException exception) {
            answer = exception.getMessage();
        } catch (MovieException exception) {
            answer = exception.getMessage();
        } catch (RoomException exception) {
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
    public String deleteScreening(String movie, String room, LocalDateTime startDate) {
        String answer;
        try {
            screeningService.deleteScreening(movie, room, startDate);
            answer = "SCreening deleted";
        } catch (ScreeningException exception) {
            answer = exception.getMessage();
        }
        return answer;
    }

    public String listScreenings() {
        String answer;
        List<Screening> screenings = screeningService.listScreenings();
        if (screenings.isEmpty()) {
            answer = "There are no screenings";
        }
        else {
            answer = screenings.stream().map(this::mapToStringScreening).collect(Collectors.joining(System.lineSeparator()));
        }
        return answer;
    }

    private String mapToStringScreening(Screening screening) {
        return String.format("%s (%s, %d minutes), screened in room %s, at %s", screening.getMovie().getTitle(),
                screening.getMovie().getGenre(), screening.getMovie().getLength(), screening.getRoom().getName()
                );
    }

}
