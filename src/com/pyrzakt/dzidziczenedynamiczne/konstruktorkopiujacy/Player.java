package com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy;

public class Player extends Person{
    double salary;

    public Player(Person person,double salary) {
        super(person.firstName, person.lastName, person.teamName);
        setSalary(salary);
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
}
