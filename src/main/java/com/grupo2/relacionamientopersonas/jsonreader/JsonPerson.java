package com.grupo2.relacionamientopersonas.jsonreader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPerson {
    private Integer dni;
    private String name;
    private String lastname;
}
