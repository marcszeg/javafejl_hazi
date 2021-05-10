package com.epam.training.ticketservice.controller;

import org.springframework.shell.Availability;

public interface AdminMethodCheck {
    Availability isAdminSignedIn();
}
