package com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy;

import java.util.HashSet;
import java.util.Set;

public class Waist extends Person{
    private int subscriptionNumber;

    private static Set<Waist> waists = new HashSet<>();

    public Waist(Person person, int subscriptionNumber) {
        super(person.firstName, person.lastName, person.teamName);
        setSubscriptionNumber(subscriptionNumber);
        waists.add(this);
       Person.removePerson(person);
    }


    //gettery i settery atrybutów


    public void setSubscriptionNumber(int subscriptionNumber) {
        if(subscriptionNumber<=0){
            throw new IllegalArgumentException("Niepoprawny numer karnetu");
        }else {
            this.subscriptionNumber = subscriptionNumber;
        }
    }
}
