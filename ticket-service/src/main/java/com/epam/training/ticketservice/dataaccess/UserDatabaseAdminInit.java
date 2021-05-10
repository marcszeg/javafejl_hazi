package com.epam.training.ticketservice.dataaccess;

import com.epam.training.ticketservice.dataaccess.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserDatabaseAdminInit {

    private UserDao userDao;

    @PostConstruct
    public void databaseAdminInit(){
        userDao.save(new UserEntity("admin", "admin", true));
    }

}
