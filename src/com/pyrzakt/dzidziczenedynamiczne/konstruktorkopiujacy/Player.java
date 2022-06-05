package com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy;

import java.util.HashSet;
import java.util.Set;

public class Player extends Person{
    double salary;

    private static Set<Player> players = new HashSet<>();

    public Player(Person person,double salary) {
        super(person.firstName, person.lastName, person.teamName);
        setSalary(salary);
        Person.removePerson(person);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<=0){
            throw new IllegalArgumentException("Błędna wartość wynagrodzenia");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
