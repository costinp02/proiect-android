package com.example.proiect.user;


import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    public List<User> users;
    User user1 = new User(1,"Jesse","email1@gmail.com", "pass123");
    User user2 = new User(2,"Walt","email2@gmail.com", "password");
    User user3 = new User(3,"Mike","email3@gmail.com", "hello2023");

    public UserRepo() {
        users = new ArrayList<>();
        User user1 = new User(1,"Jesse","email1@gmail.com", "pass123");
        User user2 = new User(2,"Walt","email2@gmail.com", "password");
        User user3 = new User(3,"Mike","email3@gmail.com", "hello2023");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

}
