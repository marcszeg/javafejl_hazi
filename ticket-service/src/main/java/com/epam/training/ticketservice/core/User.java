package com.epam.training.ticketservice.core;

public class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        User user = (User) o;
        return (user.username == this.username
                && user.password == this.password
                && user.isAdmin == this.isAdmin);
    }
}
