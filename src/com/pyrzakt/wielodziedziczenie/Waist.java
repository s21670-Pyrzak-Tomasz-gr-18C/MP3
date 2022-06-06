package com.pyrzakt.wielodziedziczenie;



import com.pyrzakt.abstrakcyjnapolmorfizm.Client;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Waist extends Person {

    private int subscriptionNumber;
    private int numberOfSubscriptionSeasons;
    private boolean vipStatus;

    private static Set<Waist> waists = new HashSet<>();

    public Waist(String firstName, String lastName, String teamName, int subscriptionNumber, int numberOfSubscriptionSeasons) {
        super(firstName, lastName, teamName);
        setSubscriptionNumber(subscriptionNumber);
        setNumberOfSubscriptionSeasons(numberOfSubscriptionSeasons);
        trySetVIPStatus();
    }

    //gettery settery atrybutów

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

    public int getNumberOfSubscriptionSeasons() {
        return numberOfSubscriptionSeasons;
    }

    public void setNumberOfSubscriptionSeasons(int numberOfSubscriptionSeasons) {
        if (numberOfSubscriptionSeasons > 0) {
            this.numberOfSubscriptionSeasons = numberOfSubscriptionSeasons;
        }else
            throw new IllegalArgumentException("Subskrypcja musi obejmowac przynajmniej jeden sezon");
    }

    public boolean isVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    // obsługa ekstensji
    public static List<Waist> getWaists() {
        return java.util.Collections.unmodifiableList(waists.stream().collect(Collectors.toList()));
    }

    public void trySetVIPStatus() {
        if(this.vipStatus == false && numberOfSubscriptionSeasons>2) {
            setVipStatus(true);
        }
    }

    @Override
    public String toString() {
        return "Waist{" +
                "subscriptionNumber=" + subscriptionNumber +
                '}';
    }
}
