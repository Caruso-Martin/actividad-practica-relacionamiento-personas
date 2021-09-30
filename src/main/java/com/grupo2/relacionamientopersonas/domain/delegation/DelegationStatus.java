package com.grupo2.relacionamientopersonas.domain.delegation;

public enum DelegationStatus {
    WAITING,
    REJECTED,
    ACCEPTED;

    //<editor-fold desc="fromInteger() and toString()" defaultstate="collapsed">

    public static DelegationStatus fromInteger(int statusNumber) {
        switch(statusNumber) {
            case 0:
                return WAITING;
            case 1:
                return REJECTED;
            case 2:
                return ACCEPTED;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //</editor-fold>
}
