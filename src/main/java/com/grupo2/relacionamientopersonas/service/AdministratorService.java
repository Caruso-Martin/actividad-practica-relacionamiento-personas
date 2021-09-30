package com.grupo2.relacionamientopersonas.service;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.repository.DelegationRepository;
import com.grupo2.relacionamientopersonas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    private final PersonRepository personRepository;
    private final DelegationRepository delegationRepository;

    @Autowired
    public AdministratorService(PersonRepository personRepository, DelegationRepository delegationRepository) {
        this.personRepository = personRepository;
        this.delegationRepository = delegationRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Delegation> getAllDelegations() {
        return delegationRepository.findAll();
    }
}
