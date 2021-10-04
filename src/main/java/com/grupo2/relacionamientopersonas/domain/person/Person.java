package com.grupo2.relacionamientopersonas.domain.person;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.domain.delegation.DelegationStatus;
import com.grupo2.relacionamientopersonas.domain.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;

    private Long dni;
    private String name;
    private String lastname;
    private String city;
    private String locality;
    private LocalDate birthday;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delegativeDelegations_id")
    private List<Delegation> delegativeDelegations; // "Son las que el usuario autoriza"

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delegateDelegations_id")
    private List<Delegation> delegateDelegations;   // "Son las que el usuario es autorizado"

    private void acceptDelegation(Delegation delegation) {
        delegation.setStatus(DelegationStatus.ACCEPTED);
    }

    private void rejectDelegation(Delegation delegation) {
        delegation.setStatus(DelegationStatus.REJECTED);
    }

    //<editor-fold desc="Constructors" defaultstate="collapsed">

    public Person(Long dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }

    public Person() {
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<Delegation> getDelegativeDelegations() {
        return delegativeDelegations;
    }

    public void setDelegativeDelegations(List<Delegation> delegativeDelegations) {
        this.delegativeDelegations = delegativeDelegations;
    }

    public void addDelegativeDelegation(Delegation delegativeDelegation) {
        this.delegativeDelegations.add(delegativeDelegation);
    }

    public List<Delegation> getDelegateDelegations() {
        return delegateDelegations;
    }

    public void setDelegateDelegations(List<Delegation> delegateDelegations) {
        this.delegateDelegations = delegateDelegations;
    }

    public void addDelegateDelegation(Delegation delegateDelegation) {
        this.delegateDelegations.add(delegateDelegation);
    }

    //</editor-fold>
}
