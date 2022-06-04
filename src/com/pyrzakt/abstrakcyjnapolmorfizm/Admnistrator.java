package com.pyrzakt.abstrakcyjnapolmorfizm;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Admnistrator extends Person {

    private Calendar dateOfEmployment;


    public Admnistrator(String name, String lastName, String phoneNumber, Calendar dateOfEmployment) {
        super(name, lastName, phoneNumber);
        setDateOfEmployment(dateOfEmployment);
    }


    public Calendar getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Calendar dateOfEmployment) {
        if (dateOfEmployment == null || dateOfEmployment.after(Calendar.getInstance().getTime())) {
            throw new IllegalArgumentException("Podano niewłaściwą datę");
        } else {
            this.dateOfEmployment = dateOfEmployment;
        }
    }

    @Override
    public void giveVIPStatus(Client client) {
        client.setIsVIP(true);
    }
}
