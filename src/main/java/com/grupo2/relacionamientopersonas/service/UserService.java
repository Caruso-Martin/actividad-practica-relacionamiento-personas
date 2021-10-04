package com.grupo2.relacionamientopersonas.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.domain.User;
import com.grupo2.relacionamientopersonas.jsonreader.JsonPerson;
import com.grupo2.relacionamientopersonas.repository.PersonRepository;
import com.grupo2.relacionamientopersonas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    @Autowired
    public UserService(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    public User getUserById(Long userId) {
        this.validateUserId(userId);
        return userRepository.findUserById(userId);
    }

    public void signUp(JsonPerson jsonPerson) throws IOException {
        if(this.validateSignUp(jsonPerson)) {
            this.addUser(jsonPerson);
            this.addPerson(jsonPerson);
        }
    }

    //<editor-fold desc="Auxiliar methods: 'signUpUser()' " defaultstate="collapsed">

    private void addUser(JsonPerson jsonPerson) {
        User user = new User(jsonPerson.getName().charAt(0) + "." + jsonPerson.getLastname(), jsonPerson.getLastname());
        user.setId(userRepository.count() + 1);

        userRepository.save(user);
    }

    private void addPerson(JsonPerson jsonPerson) {
        Person person = new Person(jsonPerson.getDni(), jsonPerson.getName(), jsonPerson.getLastname());

        person.setId(personRepository.count() + 1);
        person.setUser(userRepository.getById(userRepository.count()));

        personRepository.save(person);
    }

    //</editor-fold>

    public Boolean logIn(User user) {
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

    private Boolean validateSignUp(JsonPerson jsonPerson) throws IOException {
        List<JsonPerson> persons = this.getPersonsFromJSON();
        //TODO: Validar si la persona tiene un usuario ya registrado

        Boolean allowedPerson = persons.stream().anyMatch(p -> Objects.equals(p.getDni(), jsonPerson.getDni()) && Objects.equals(p.getName(), jsonPerson.getName()) && Objects.equals(p.getLastname(), jsonPerson.getLastname()));
        Boolean alreadyRegistered = userRepository.existsByUsername(jsonPerson.getName().charAt(0) + "." + jsonPerson.getLastname());

        return allowedPerson && !alreadyRegistered;
    }

    private List<JsonPerson> getPersonsFromJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/resources/personas.json"), new TypeReference<List<JsonPerson>>() {});
    }

    private Boolean validateLogIn(User user) {
        // TODO
        return userRepository.existsByUsername(user.getUsername());
    }

    //</editor-fold>
}
