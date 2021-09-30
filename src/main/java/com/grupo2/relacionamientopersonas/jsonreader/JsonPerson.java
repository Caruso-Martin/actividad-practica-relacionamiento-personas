package com.grupo2.relacionamientopersonas.jsonreader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPerson {
    private Integer dni;
    private String name;
    private String lastname;

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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
