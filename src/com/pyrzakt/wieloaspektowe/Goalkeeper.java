package com.pyrzakt.wieloaspektowe;

public class Goalkeeper extends Player{
     private int savedPenalty;

    public Goalkeeper(String firstName, String lastName, String teamName, double salary, int savedPenalty) {
        super(firstName, lastName, teamName, salary);
        setSavedPenalty(savedPenalty);

    }

    public int getSavedPenalty() {
        return savedPenalty;
    }

    public void setSavedPenalty(int savedPenalty) {
        if (savedPenalty<0){
            throw new IllegalArgumentException("Podano niewłaściwą liczbe obronionych rzutów karnych");
        }
        this.savedPenalty = savedPenalty;
    }

    public void giveBonuses(){
        if(savedPenalty>1){
            this.setSalary(this.getSalary()*1.1);
            setSavedPenalty(0);
        }
    }

    @Override
    public String toString() {
        return "Goalkeeper{" +
                "savedPenalty=" + savedPenalty +
                '}';
    }
}
