package com.grupo2.relacionamientopersonas.domain.person;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @SequenceGenerator(
            name = "photo_sequence",
            sequenceName = "photo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photo_sequence"
    )
    private Long id;

    private String url;
    private String size;

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    //</editor-fold>
}
