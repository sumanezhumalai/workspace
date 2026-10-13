package com.sumanezhumalai.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String Street;
    private String Town;
    private String State;   

    public Address(){}

    @Override
    public String toString() {
        return "Address [Street=" + Street + ", Town=" + Town + ", State=" + State + "]";
    }

    public Address(String street, String town, String state) {
        Street = street;
        Town = town;
        State = state;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
