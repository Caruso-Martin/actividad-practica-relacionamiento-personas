package com.grupo2.relacionamientopersonas.controller;

import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "{personId}")
    public Person getPersonById(@PathVariable("personId") Long personId) {
        return personService.getPersonById(personId);
    }

    @PutMapping(path = "update") // Item: 3
    public void updatePersonData(@RequestBody Person person) {
        personService.updatePersonData(person);
    }
}
