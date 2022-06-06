package com.pyrzakt.wielodziedziczenie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {


    private String firstName;
    private String lastName;
    private String teamName;



    private static Set<Person> persons = new HashSet<Person>();

    public Person(String firstName, String lastName, String teamName) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        persons.add(this);
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

    //obsługa ekstensji
    public static List<Person> getPersons() {
        return java.util.Collections.unmodifiableList(persons.stream().collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
