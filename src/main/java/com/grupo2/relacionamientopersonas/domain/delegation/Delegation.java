package com.grupo2.relacionamientopersonas.domain.delegation;

import com.grupo2.relacionamientopersonas.domain.person.Person;
import com.grupo2.relacionamientopersonas.jsonreader.JsonPerson;

import javax.persistence.*;

@Entity
@Table(name = "delegation")
public class Delegation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delegative_id")
    private JsonPerson delegative;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delegate_id")
    private JsonPerson delegate;

    @Enumerated(EnumType.STRING)
    private DelegationStatus status;

    //<editor-fold desc="Constructors" defaultstate="collapsed">

    public Delegation(JsonPerson delegative, JsonPerson delegate) {
        this.delegative = delegative;
        this.delegate = delegate;
        this.status = DelegationStatus.WAITING;
    }

    public Delegation() {
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JsonPerson getDelegative() {
        return delegative;
    }

    public void setDelegative(JsonPerson delegative) {
        this.delegative = delegative;
    }

    public JsonPerson getDelegate() {
        return delegate;
    }

    public void setDelegate(JsonPerson delegation) {
        this.delegate = delegation;
    }

    public DelegationStatus getStatus() {
        return status;
    }

    public void setStatus(DelegationStatus status) {
        this.status = status;
    }

    //</editor-fold>
}
