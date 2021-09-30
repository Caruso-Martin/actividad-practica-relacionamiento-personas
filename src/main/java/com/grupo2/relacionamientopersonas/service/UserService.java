package com.grupo2.relacionamientopersonas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.grupo2.relacionamientopersonas.domain.user.User;
import com.grupo2.relacionamientopersonas.jsonreader.JsonPerson;
import com.grupo2.relacionamientopersonas.jsonreader.PersonResponse;
import com.grupo2.relacionamientopersonas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        this.validateUserId(userId);
        return userRepository.findUserById(userId);
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

    private void validateUserId(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");
        //throw new IllegalAccessException("ID " + id + " invalido");

        if(!userRepository.existsById(id))
            System.out.println("No existe un usuario con ID " + id);
        //throw new IllegalAccessException("No existe un usuario con ID " + id);
    }

    private Boolean validateSignUp(Integer dni, String name, String lastname) {
        //TODO: Validar si la persona existe en el JSON
        //TODO: Validar si la persona tiene un usuario ya registrado
        return true;
    }

    private Boolean validateLogIn(User user) {
        //TODO: Validar si el usuario existe en la DB
        return true;
    }

    private void getDataFromJSON() throws IOException {
        //TODO
        //InputStream inputJsonStream = JsonPerson.class.getResourceAsStream("personas.json");
        //List<JsonPerson> jsonPersonList = new ObjectMapper().readValue(inputJsonStream, new TypeReference<List<JsonPerson>>() {});

        //jsonPersonList.forEach(p -> System.out.println("DNI: " + p.getDni() + "Nombre: " + p.getName() + "Apellido: " + p.getLastname()));
    }

    //</editor-fold>
}
