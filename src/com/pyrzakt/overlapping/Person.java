package com.pyrzakt.overlapping;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Person {

        private String firstName;
        private String lastName;
        private String teamName;
        private double salary;
        private int subscriptionNumber;

        private EnumSet<PersonType> personKind = EnumSet.of(PersonType.Person); //dyskryminator

    public Person(String firstName, String lastName, String teamName, EnumSet<PersonType> personTypes) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        setPersonKind(personTypes);

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

    public double getSalary() throws Exception {
        if (personKind.contains(PersonType.Coach) || personKind.contains(PersonType.Player)) {
            return salary;
        }else{
            throw new Exception("Wynagrodzenie dostępne tylko dla zawodników i trenerów");
        }
    }

    public void setSalary(double salary) throws Exception {
        if (personKind.contains(PersonType.Coach) || personKind.contains(PersonType.Player)) {
            this.salary = salary;
        }else{
            throw new Exception("Wynagrodzenie dostępne tylko dla zawodników i trenerów");
        }
    }

    public int getSubscriptionNumber() throws Exception {
        if (personKind.contains(PersonType.Waist)) {
            return subscriptionNumber;
        }else{
            throw new Exception("Tylko kibice posiadaja karnety meczowe");
        }
    }

    public void setSubscriptionNumber(int subscriptionNumber) throws Exception {
        if (personKind.contains(PersonType.Waist)) {
            this.subscriptionNumber = subscriptionNumber;
        }else{
            throw new Exception("Karnety meczowe dostępne tylko dla kibiców");
        }

    }

    public EnumSet<PersonType> getPersonKind() {
        return personKind;
    }

    private void setPersonKind(EnumSet<PersonType> personKind) {
        this.personKind = personKind;
    }
}
