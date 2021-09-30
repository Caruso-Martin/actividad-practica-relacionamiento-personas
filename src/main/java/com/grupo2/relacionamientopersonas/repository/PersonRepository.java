package com.grupo2.relacionamientopersonas.repository;

import com.grupo2.relacionamientopersonas.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonById(Long personId);
}
