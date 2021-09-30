package com.grupo2.relacionamientopersonas.domain.delegation;

import com.grupo2.relacionamientopersonas.domain.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "delegation")
public class Delegation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delegative_id")
    private Person delegative;

    @ManyToOne
    @JoinColumn(name = "delegate_id")
    private Person delegate;

    @Enumerated(EnumType.STRING)
    private DelegationStatus status;

    //<editor-fold desc="Getters and Setters" defaultstate="collapsed">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getDelegative() {
        return delegative;
    }

    public void setDelegative(Person delegative) {
        this.delegative = delegative;
    }

    public Person getDelegate() {
        return delegate;
    }

    public void setDelegate(Person delegation) {
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
