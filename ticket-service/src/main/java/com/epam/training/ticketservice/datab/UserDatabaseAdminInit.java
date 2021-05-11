package com.epam.training.ticketservice.datab;

import com.epam.training.ticketservice.datab.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserDatabaseAdminInit {

    private UserDao userDao;

    public UserDatabaseAdminInit(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    public void databaseAdminInit() {
        userDao.save(new UserEntity("admin", "admin", true));
    }

}
