package com.pyrzakt.overlappingkompozycja;

public class Player {
    private double salary;

    public Player(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<=0){
            throw new IllegalArgumentException("Błedna wartość wynagrodzenia");
        }
        this.salary = salary;
    }


}
