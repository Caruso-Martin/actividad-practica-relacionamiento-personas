package com.grupo2.relacionamientopersonas.service;

import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long personId){
        this.validatePersonId(personId);

        return personRepository.findPersonById(personId);
    }

    @Transactional
    public void updatePersonData(Person newPerson) {
        this.validatePersonId(newPerson.getId());

        Person person = this.getPersonById(newPerson.getId());
        person.setCity(newPerson.getCity());
        person.setLocality(newPerson.getLocality());
        person.setBirthday(newPerson.getBirthday()); // Ejemplo: "2020-06-28"
        person.setPhoto(newPerson.getPhoto());       // TODO: Guardar foto
    }

    //<editor-fold desc="Validations" defaultstate="collapsed">

    private void validatePersonId(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");
            //throw new IllegalAccessException("ID " + id + " invalido");

        if(!personRepository.existsById(id))
            System.out.println("No existe una persona con ID " + id);
            //throw new IllegalAccessException("No existe una persona con ID " + id);
    }

    /*private void validatePersonDuplicate(Integer id) {
        if(personRepository.existsById(id))
            throw new CustomException("La persona ya existe");
    }*/

    //</editor-fold>
}
