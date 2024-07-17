package com.sunil.spring.schrduler.service;

import com.sunil.spring.schrduler.dao.UserDao;
import com.sunil.spring.schrduler.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    Logger log = LoggerFactory.getLogger(UserService.class);

//  schedule a job to add object in DB (Every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        Users user = new Users();
        user.setName("user " + new Random().nextInt(374483));
        dao.save(user);
        System.out.println("add service call in " + new Date().toString());
    }

    @Scheduled(cron="0/15 * * * * *")
    public void fetchDBJob() {
        List<Users> users = dao.findAll();
        System.out.println("fetch service call in " + new Date().toString());
        System.out.println("no.of record fetched : " + users.size());
        log.info("users : {}", users);
    }
}
