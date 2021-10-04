package com.grupo2.relacionamientopersonas.controller;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "administrator")
public class AdministratorController {
    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    //TODO: Los endpoints deberian pedir la autorizacion de "Administrador"

    @GetMapping(path = "person-list") // Item: 8
    public List<Person> getAllPersons() {
        return administratorService.getAllPersons();
    }

    @GetMapping(path = "delegation-list") // Item: 9
    public List<Delegation> getAllDelegations() {
        return administratorService.getAllDelegations();
    }
}
