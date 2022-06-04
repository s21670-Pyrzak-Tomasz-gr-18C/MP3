package com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy;

import java.util.HashSet;
import java.util.Set;

public class Waist extends Person{
    private int iD;
    private static int counter;
    private int subscriptionNumber;
    private Person person;

    private static Set<Waist> waists = new HashSet<>();

    public Waist(Person person, int subscriptionNumber) {
        super(person.firstName, person.lastName, person.teamName);
        setSubscriptionNumber(subscriptionNumber);
        counter++;
        setiD(counter);
        waists.add(this);
        setPerson(person);
    }


    //gettery i settery atrybutów

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(int subscriptionNumber) {
        if(subscriptionNumber<=0){
            throw new IllegalArgumentException("Niepoprawny numer karnetu");
        }else {
            this.subscriptionNumber = subscriptionNumber;
        }
    }
}
