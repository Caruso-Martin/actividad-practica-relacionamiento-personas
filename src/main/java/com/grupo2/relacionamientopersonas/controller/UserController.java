package com.grupo2.relacionamientopersonas.controller;

import com.grupo2.relacionamientopersonas.domain.User;
import com.grupo2.relacionamientopersonas.jsonreader.JsonPerson;
import com.grupo2.relacionamientopersonas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "signup") // Item: 1
    public void signUpUser(@RequestBody JsonPerson jsonPerson) throws IOException {
        userService.signUp(jsonPerson);
    }

    @PostMapping(path = "login") // Item: 2
    public Boolean userLogIn(@RequestBody User user) {
        return userService.logIn(user);
    }


    //TODO: Mantener sesion abierta -> Log Out User
    //@PostMapping(path = "login") // Item: 12
    //public Boolean userLogOut(@RequestBody User user) {
    //    return userService.logIn(user);
    //}
}
