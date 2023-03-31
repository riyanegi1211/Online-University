package com.example.demo.model;

public enum Role {
    STUDENT,
    PROFESSOR,
    ADMIN,
    GUEST;

    @Override
    public String toString() {
        switch (this) {
            case STUDENT:
                return "STUDENT";
            case PROFESSOR:
                return "PROFESSOR";
            case ADMIN:
                return "ADMIN";
            case GUEST:
                return "GUEST";
            default:
                throw new IllegalArgumentException("Unknown Role value: " + this);
        }
    }
}
