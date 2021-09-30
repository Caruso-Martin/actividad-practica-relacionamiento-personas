package com.grupo2.relacionamientopersonas.controller;

import com.grupo2.relacionamientopersonas.domain.user.User;
import com.grupo2.relacionamientopersonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping // Item: 1
    public void signUpUser(@RequestBody Integer dni, @RequestBody String name, @RequestBody String lastname, @RequestBody User user) {
        userService.signUpUser(dni, name, lastname, user);
    }

    /*@XMapping // Item: 2
    public void userLogIn(User user) {
        return userService.userLogin(User user);
    }*/

}
