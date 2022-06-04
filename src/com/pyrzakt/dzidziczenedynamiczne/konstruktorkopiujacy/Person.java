package com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy;

import com.pyrzakt.overlappingkompozycja.Waist;

public class Person {

    protected String firstName;
    protected String lastName;
    protected String teamName;


    public Person(String firstName, String lastName, String teamName) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Podano nieprawidłowe imie");
        } else {
            this.firstName = name;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName == null || teamName.length() == 0){
            throw new IllegalArgumentException("Podano nieprawidłową nazwę drużyny");
        }
        this.teamName = teamName;
    }

    public void removeWaist(Waist waist) {
    }
}
