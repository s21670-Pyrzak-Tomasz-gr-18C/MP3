package com.pyrzakt.overlappingkompozycja;

import com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Waist {
    private int iD;
    private static int counter;
    private int subscriptionNumber;
    private Person person;

    private static Set<Waist> waists = new HashSet<>();

    public Waist(int subscriptionNumber) {
        setSubscriptionNumber(subscriptionNumber);
        counter++;
        setiD(counter);
        waists.add(this);
        setPerson(person);
    }
        //gettery settery atrybutów
    private void setPerson(Person person) {
        this.person=person;
    }

    public Person getPerson() {
        return person;
    }


    public Waist getWeist(int id) throws Exception {
        Waist notFindedWaist = null;
        for (Waist waist: waists) {
            if(waist.iD == id){
                return waist;
            }
        }
        throw new Exception("Nie znaleziono kibica o podanym id");
    }

    private void setiD(int counter) {
        this.iD = counter;
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

    // obsługa ekstensji
    public static List<Waist> getWaists() {
        return java.util.Collections.unmodifiableList(waists.stream().toList());
    }

    public static boolean removeWaist(Waist waist) throws Exception{
        if(waist == null || !waists.contains(waist)){
            return false;
        }
        if(waist.getPerson().hasWaist(waist)){
            waists.remove(waist);
            waist.getPerson().removeWaist(waist);
            return true;
        }
        return false;
    }
}
