package com.pyrzakt;

import com.pyrzakt.abstrakcyjnapolmorfizm.Admnistrator;
import com.pyrzakt.abstrakcyjnapolmorfizm.Client;
import com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Player;
import com.pyrzakt.overlapping.Person;
import com.pyrzakt.overlapping.PersonType;
import com.pyrzakt.overlappingkompozycja.Waist;
import com.pyrzakt.wieloaspektowe.Attacker;
import com.pyrzakt.wieloaspektowe.ExperienceLevel;
import com.pyrzakt.wieloaspektowe.Junior;
import com.pyrzakt.wielodziedziczenie.WaistPlayer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) throws Exception {

    // klasa abstrakcyjna/ polimorfizm metod
        System.out.println(" klasa abstrakcyjna/ polimorfizm metod");
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
        System.out.println("dzidziczenie typu overlapping spłaszczenie hierarchii");
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

        System.out.println("------------------------------------------------------");

       //  dziedziczenie typu overlapping zastąpienie kompozycją
        System.out.println("dziedziczenie typu overlapping zastąpienie kompozycją");
        com.pyrzakt.overlappingkompozycja.Person person = new com.pyrzakt.overlappingkompozycja.Person("Adam", "Nowy","Klopsy");
       Waist waist1 = new Waist(7898,person);
       System.out.println(waist1.toString());
       System.out.println("Numer karnetu dla kibica waist1: "+person.getWaist(1).getSubscriptionNumber());
        System.out.println("------------------------------------------------------");

        // dziedziczenie dynamiczne konstruktor kopiujacy
        System.out.println("dziedziczenie dynamiczne konstruktor kopiujacy");
        com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Person person1 = new com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Person("Marcin","Kartofel","Kocury");
        System.out.println("Ekstensja klasy Person: "+com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Person.getPersons());
        Player player1 = new Player(person1,5500);
        System.out.println("Ekstensja klasy Person po zmianie Obiektu na Player: "+com.pyrzakt.dzidziczenedynamiczne.konstruktorkopiujacy.Person.getPersons());

        System.out.println("------------------------------------------------------");

        //dziedziczemie dynamiczne spłasczenie hierarchii
        System.out.println("dziedziczemie dynamiczne spłasczenie hierarchii");
        com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.Person person2 = new com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.Person("Aleksander","Wielki","Zwycięzcy", com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Coach);
        person2.setSalary(8000);
        System.out.println("Ekstensja klasy Person"+ com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.Person.getPersons().toString());
        person2.changePersonType(com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.PersonType.Waist);
        person2.setSubscriptionNumber(43576);
        System.out.println("Ekstensja klasy Person"+ com.pyrzakt.dziadziczeniedynamiczne.splasczeniehierarchii.Person.getPersons().toString());
        System.out.println("------------------------------------------------------");

        //dziedziczenie dynamiczne kompozycja
        System.out.println("dziedziczenie dynamiczne kompozycja");
        com.pyrzakt.dziedziczeniedynamicznekompozycja.Person person3 = new com.pyrzakt.dziedziczeniedynamicznekompozycja.Person("Alicja", "Bąk", "Bąkojady");
        com.pyrzakt.dziedziczeniedynamicznekompozycja.Player player3 = new com.pyrzakt.dziedziczeniedynamicznekompozycja.Player(10000,person3);
        System.out.println(person3.toString());
        com.pyrzakt.dziedziczeniedynamicznekompozycja.Waist waist = new com.pyrzakt.dziedziczeniedynamicznekompozycja.Waist(763465834,person3);
        System.out.println(person3.toString());

        System.out.println("------------------------------------------------------");

        //wielodziedzczenie (to string metody get, metody z IPlayer. Dziedziczenie pozostawiona gałąź z metodami przesłoniętymi)
        System.out.println("wielodziedziczenie");
        WaistPlayer waistPlayer = new WaistPlayer("Paweł", "Rabarbar","Kozaki",632452374,5,4000);
        System.out.println(waistPlayer);

        /*dziedziczenie wieloaspektowe
        Po klasie Player ze względu na pozycję na boisku dziedziczą klasy Striker oraz Goalkeeper, natomiast ze względu na doświadczenie dziedziczą klasy Junior i Senior
        dziedziczenie ze względu na doświadczenie zostaje zamienione na kopozycje pomiędzy Player i Experience po której dziedziczą klasy Junior i Senior
         */

        com.pyrzakt.wieloaspektowe.Player player4 = new Attacker("Zenek","Kapusta","Loosers",5000);
          player4.addExperience(new Junior(25,player4));
        System.out.println(player4.getExperienceLevel().getExperienceLevel(player4.getExperienceLevel().getiD()).sendForAdditionalTraining());
    }

}
