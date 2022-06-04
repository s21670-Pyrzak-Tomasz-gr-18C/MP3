package com.pyrzakt.abstrakcyjnapolmorfizm;

import java.math.BigDecimal;

public class Client extends Person {
    private BigDecimal purchasesAmount;
    private Boolean isVIP = false;

    public Client(String name, String lastName, String phoneNumber) {
        super(name, lastName, phoneNumber);
    }

    public BigDecimal getPurchasesAmount() {
        return purchasesAmount;
    }

    public void setPurchasesAmount(BigDecimal purchasesAmount) {
        if (purchasesAmount.equals(null) || purchasesAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("nieprawidłowa wartość dokonanych zakupów");
        } else {
            this.purchasesAmount = purchasesAmount;
        }
    }

    public Boolean getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(Boolean VIP) {
        isVIP = VIP;
    }

    @Override
    public void giveVIPStatus(Client client) {
        if ((getPurchasesAmount().compareTo(BigDecimal.valueOf(2500)))==1){
            setIsVIP(true);
        }
    }

    public void confirmPurchase(BigDecimal value){
        setPurchasesAmount(value);
        giveVIPStatus(this);
    }
}
