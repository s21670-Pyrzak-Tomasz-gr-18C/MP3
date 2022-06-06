package com.pyrzakt.dziedziczeniedynamicznekompozycja;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Waist {
    protected int iD;
    private static int counter;
    private int subscriptionNumber;
    private Person person;

    private static Set<Waist> waists = new HashSet<>();

    public Waist(int subscriptionNumber, Person person) {
        setPerson(person);
        setSubscriptionNumber(subscriptionNumber);
        counter++;
        setiD(counter);
        waists.add(this);
    }
    //gettery settery atrybutów

    public Person getPerson() {
        return person;
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

    private void setPerson(Person person){
        if(person.getPlayer()!=null){
            person.setPlayer(null);
        }
        this.person = person;
        person.setWaist(this);
    }

    // obsługa ekstensji
    public static List<Waist> getWaists() {
        return java.util.Collections.unmodifiableList(waists.stream().collect(Collectors.toList()));
    }


    public static boolean removeWaist(Waist waist) throws Exception{
        if(waist == null || !waists.contains(waist)){
            return false;
        }
        if(waist.getPerson().getWaist().equals(waist)){
            waists.remove(waist);
            waist.getPerson().removeWaist(waist);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Waist{" +
                "iD=" + iD +
                ", subscriptionNumber=" + subscriptionNumber +
                '}';
    }
}
