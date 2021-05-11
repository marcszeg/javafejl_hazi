package com.epam.training.ticketservice.ui;

import org.springframework.shell.Availability;

public interface AdminMethodCheck {
    Availability isAdminSignedIn();
}
