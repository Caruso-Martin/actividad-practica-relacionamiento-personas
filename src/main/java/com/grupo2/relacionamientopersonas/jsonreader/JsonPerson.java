package com.grupo2.relacionamientopersonas.jsonreader;

import javax.persistence.*;

@Entity
@Table(name = "personbasicinfo")
public class JsonPerson {
    @Id
    @SequenceGenerator(
            name = "personbasicinfo_sequence",
            sequenceName = "personbasicinfo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personbasicinfo_sequence"
    )
    private Long id;

    private Long dni;
    private String name;
    private String lastname;

    //<editor-fold desc="Constructors" defaultstate="collapsed">

    public JsonPerson(Long dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }

    public JsonPerson() {
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

    //</editor-fold>
}
