package com.pyrzakt;

import com.pyrzakt.abstrakcyjnapolmorfizm.Admnistrator;
import com.pyrzakt.abstrakcyjnapolmorfizm.Client;
import com.pyrzakt.overlapping.Person;
import com.pyrzakt.overlapping.PersonType;
import com.pyrzakt.overlappingkompozycja.Player;
import com.pyrzakt.overlappingkompozycja.Waist;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {

    // klasa abstrakcyjna/ polimorfizm metod
        Calendar c = Calendar.getInstance();
        c.set(20022,  02, 20);

        Admnistrator admin = new Admnistrator("Adam","Nowak","9800088899", c);
        Client client =  new Client("Anna","Kowalska", "9585789987");
        Client client2 =  new Client("Magdalena","Marchewka", "9585789987");

        /*przesłonięcie metod
        nadanie statusu VIP dla klientów którzy dokonali zamówienia powyżej 2500
         */

        admin.giveVIPStatus(client);
        System.out.println("Klient posiada status Vip: "+client.getIsVIP());
        client2.confirmPurchase(BigDecimal.valueOf(4500));
        System.out.println("Klient 2 posiada status Vip: "+ client2.getIsVIP());
        System.out.println("------------------------------------------------------");

    //dzidziczenie typu overlapping spłaszczenie hierarchii
        EnumSet<PersonType> personTypes = EnumSet.allOf(PersonType.class);
        EnumSet<PersonType> personTypes2 = EnumSet.of(PersonType.Coach);
        Person player = new Person("Piotr", "Gruszka","PogońBydło", personTypes2);
        Person multiType = new Person("Adam","Kapusta","DreamTeam",personTypes);

       try{
    //      player.setSubscriptionNumber(45667);  //wyjątek zawodnik nie moze posiadac karnetu
           multiType.setSubscriptionNumber(36365);
           multiType.setSalary(58525.58);
           System.out.println("multiType Person : "+java.util.Arrays.asList(multiType.getPersonKind()));
       }catch (Exception e) {
           e.printStackTrace();
       }

       //  dziedziczenie typu overlapping zastąpienie kompozycją

        com.pyrzakt.overlappingkompozycja.Person person = new com.pyrzakt.overlappingkompozycja.Person("Adam", "Nowy","Klopsy",new Waist(4765));
        person.getWaist(1).setSubscriptionNumber(7898);
        System.out.println(person.getWaist(1).getSubscriptionNumber());



    }

}
