package com.pyrzakt.wielodziedziczenie;

public class Player extends Person implements IPlayer {
    private double salary;

    public Player(String firstName, String lastName, String teamName, double salary) {
        super(firstName, lastName, teamName);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Niepoprawna wartość zarobków");
        } else {
            this.salary = salary;
        }
    }

}
