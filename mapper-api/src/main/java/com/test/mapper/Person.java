package com.test.mapper;

import java.util.Date;
import java.util.List;

/**
 * Created by sbt-selin-an on 24.06.2016.
 */
public class Person {

    private String FirstName;
    private Date birthDate;
    private List<Address> addressList;
    private Snils snils;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Snils getSnils() {
        return snils;
    }

    public void setSnils(Snils snils) {
        this.snils = snils;
    }
}
