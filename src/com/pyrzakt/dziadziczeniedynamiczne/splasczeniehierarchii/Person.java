package com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {

    private String firstName;
    private String lastName;
    private String teamName;
    private double salary;
    private int subscriptionNumber;

    private static Set<Person> persons = new HashSet<Person>();

    private com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType personType; //dyskryminator


    public Person(String firstName, String lastName, String teamName, PersonType personType) throws Exception {
        setPersonType(personType);
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

    public double getSalary() throws Exception {
        if (personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Coach) || personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Player)) {
            return salary;
        }else{
            throw new Exception("Wynagrodzenie dostępne tylko dla zawodników i trenerów");
        }
    }

    public void setSalary(double salary) throws Exception {
        if (personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Coach) || personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Player)) {
            this.salary = salary;
        }else{
            throw new Exception("Wynagrodzenie dostępne tylko dla zawodników i trenerów");
        }
    }

    public int getSubscriptionNumber() throws Exception {
        if (personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Waist)) {
            return subscriptionNumber;
        }else{
            throw new Exception("Tylko kibice posiadaja karnety meczowe");
        }
    }

    public void setSubscriptionNumber(int subscriptionNumber) throws Exception {
        if (personType.equals(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Waist)) {
            this.subscriptionNumber = subscriptionNumber;
        }else{
            throw new Exception("Karnety meczowe dostępne tylko dla kibiców");
        }

    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        if(personType!=null) {
            this.personType = personType;
        }
    }

    public void changePersonType(PersonType personType) throws Exception {
        if (this!=null && !this.getPersonType().equals(personType)) {
            this.personType = personType;
        }
        if(personType.equals(PersonType.Coach)||personType.equals(PersonType.Player)){
            setSalary(this.salary);
            this.subscriptionNumber=0;
        }else if (personType.equals(PersonType.Waist)){
            setSubscriptionNumber(this.subscriptionNumber);
            this.salary=0;
        }else
            throw new IllegalArgumentException("Błędne typ obiektu");
    }

    public static List<Person> getPersons() {
        return java.util.Collections.unmodifiableList(persons.stream().collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        if (this.personType.equals(PersonType.Player) || this.personType.equals(PersonType.Coach)) {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", teamName='" + teamName + '\'' +
                    ", salary=" + salary +
                    ", personType=" + personType +
                    '}';
        }if(this.personType.equals(PersonType.Waist)){
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", teamName='" + teamName + '\'' +
                    ", subscriptionNumber=" + subscriptionNumber +
                    ", personType=" + personType +
                    '}';
        }else
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", teamName='" + teamName + '\'' +
                    ", salary=" + salary +
                    ", subscriptionNumber=" + subscriptionNumber +
                    ", personType=" + personType +
                    '}';
    }
}
