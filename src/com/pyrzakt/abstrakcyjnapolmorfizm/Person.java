package com.pyrzakt.abstrakcyjnapolmorfizm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String name;
    private String lastName;
    private String phoneNumber;

    public Person(String name, String lastName, String phoneNumber) {
        setName(name);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Podano nieprawidłowe imie");
        } else {
            this.name = name;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Podano nieprawidłowe nazwisko");
        } else {

            this.lastName = lastName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!isValidMobileNo(phoneNumber)) {
            throw new IllegalArgumentException("Podano błędny numer telefonu");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public abstract void giveVIPStatus(Client client);


    private boolean isValidMobileNo(String phoneNumber) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(phoneNumber);
        return (match.find() && match.group().equals(phoneNumber));
    }



}
