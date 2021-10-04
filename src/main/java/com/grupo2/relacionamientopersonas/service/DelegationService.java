package com.grupo2.relacionamientopersonas.service;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.domain.delegation.DelegationStatus;
import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.jsonreader.JsonPerson;
import com.grupo2.relacionamientopersonas.repository.DelegationRepository;
import com.grupo2.relacionamientopersonas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DelegationService {
    private final DelegationRepository delegationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DelegationService(DelegationRepository delegationRepository, PersonRepository personRepository) {
        this.delegationRepository = delegationRepository;
        this.personRepository = personRepository;
    }

    public Delegation getDelegationById(Long idDelegation) {
        this.validateDelegationId(idDelegation);
        return delegationRepository.findDelegationById(idDelegation);
    }

    @Transactional
    public void delegationAuthorization(Long delegativeDni, Long delegateDni) {
        Person delegative = personRepository.findPersonByDni(delegativeDni);
        Person delegate = personRepository.findPersonByDni(delegateDni);

        Delegation delegation = new Delegation( this.personToJsonPerson(personRepository.findPersonByDni(delegativeDni)),
                                                this.personToJsonPerson(personRepository.findPersonByDni(delegateDni)) );

        delegative.addDelegativeDelegation(delegation);
        delegate.addDelegateDelegation(delegation);

        delegationRepository.save(delegation);
    }

    //<editor-fold desc="Auxiliar methods: 'delegationAuthorization()'" defaultstate="collapsed">

    private JsonPerson personToJsonPerson(Person person) {
        return new JsonPerson(person.getDni(), person.getName(), person.getLastname());
    }

    //</editor-fold>

    @Transactional
    public void delegationAcceptance(Long delegationId, Boolean delegationAcceptance) {
        if(delegationAcceptance)
            this.getDelegationById(delegationId).setStatus(DelegationStatus.ACCEPTED);
        else
            this.getDelegationById(delegationId).setStatus(DelegationStatus.REJECTED);
    }

    public void delegationAuthorizationRevoke(Long delegationId) {
        delegationRepository.deleteById(delegationId);
    }

    //<editor-fold desc="Validations" defaultstate="collapsed">

    private void validateDelegationId(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");
        //throw new IllegalAccessException("ID " + id + " invalido");

        if(!delegationRepository.existsById(id))
            System.out.println("No existe una delegacion con ID " + id);
        //throw new IllegalAccessException("No existe una persona con ID " + id);
    }

    //</editor-fold>
}
