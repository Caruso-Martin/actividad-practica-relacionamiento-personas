package com.grupo2.relacionamientopersonas.jsonreader;

import java.util.List;

public class PersonResponse {
    List<JsonPerson> persons;

    @Override
    public String toString() {
        return "PersonResponse{" +
                "persons=" + persons +
                '}';
    }

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public List<JsonPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<JsonPerson> persons) {
        this.persons = persons;
    }

    //</editor-fold>
}
