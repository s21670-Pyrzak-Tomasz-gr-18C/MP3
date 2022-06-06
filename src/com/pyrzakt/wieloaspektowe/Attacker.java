package com.pyrzakt.wieloaspektowe;

public class Attacker extends Player{
    private int numberOfGoals;

    public Attacker(String firstName, String lastName, String teamName, double salary) {
        super(firstName, lastName, teamName, salary);
        setNumberOfGoals(numberOfGoals);
    }


    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        if (numberOfGoals<0){
            throw new IllegalArgumentException("Podano niewłaściwą liczbe bramek");
        }else
        this.numberOfGoals = numberOfGoals;
    }

    public void giveBonuses(){
        if(numberOfGoals>10){
            this.setSalary(this.getSalary()*1.1);
            setNumberOfGoals(0);
        }
    }

    @Override
    public String toString() {
        return "Attacker{" +
                "numberOfGoals=" + numberOfGoals +
                '}';
    }
}
