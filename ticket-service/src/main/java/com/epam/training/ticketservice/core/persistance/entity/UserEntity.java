package com.epam.training.ticketservice.core.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    private String username;
    private String password;
    private boolean isAdmin;

    public UserEntity(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserEntity() {
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
        UserEntity userEntity = (UserEntity) o;
        return (userEntity.username == this.username
                && userEntity.password == this.password
                && userEntity.isAdmin == this.isAdmin);
    }
}
