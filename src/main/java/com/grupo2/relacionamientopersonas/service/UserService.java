package com.grupo2.relacionamientopersonas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.domain.user.User;
import com.grupo2.relacionamientopersonas.jsonreader.PersonResponse;
import com.grupo2.relacionamientopersonas.repository.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUpUser(Integer dni, String name, String lastname, User user) {
        if(this.validateSignUp(dni, name, lastname))
            userRepository.save(user);
    }

    public Boolean userLogIn(User user) {
        User auxUser = userRepository.findUserByUsername(user.getUsername());

        return Objects.equals(auxUser.getPassword(), user.getPassword());
    }


    //<editor-fold desc="Validations" defaultstate="collapsed">

    private Boolean validateSignUp(Integer dni, String name, String lastname) {
        //TODO: Validar si la persona existe en el JSON
        //TODO: Validar si la persona tiene un usuario ya registrado
        return true;
    }

    private Boolean validateLogIn(User user) {
        //TODO: Validar si el usuario existe en la DB
        return true;
    }

    /*private List<Person> getDataFromJSON() throws IOException {
        PersonResponse personResponse = objectMapper.readValue(jsonString, PersonResponse.class);

        https://stackoverflow.com/questions/60621834/spring-boot-how-can-i-parse-a-json-which-consists-of-an-array-of-objects-and-us
        https://www.baeldung.com/spring-classpath-file-access
    }*/

    //</editor-fold>
}
