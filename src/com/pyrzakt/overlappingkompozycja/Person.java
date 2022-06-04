package com.pyrzakt.overlappingkompozycja;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {

    private String firstName;
    private String lastName;
    private String teamName;
    private Set<Player> player;
    private Set<Waist> waist;

    private static Set<Person> persons = new HashSet<>();

    public Person(String firstName, String lastName, String teamName, Player player) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        setPlayer(player);
        persons.add(this);
    }

    public Person(String firstName, String lastName, String teamName, Waist waist) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        setWaist(waist);
        persons.add(this);
    }

    public Person(String firstName, String lastName, String teamName) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        persons.add(this);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Podano nieprawidłowe imie");
        } else {
            this.firstName = name;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Podano nieprawidłowe nazwisko");
        } else {
            this.lastName = lastName;
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName == null || teamName.length() == 0){
            throw new IllegalArgumentException("Podano nieprawidłową nazwę drużyny");
        }
        this.teamName = teamName;
    }

    public Set<Player> getPlayer() {
        return player;
    }

    private void setPlayer(Player player) {
        if (player == null){
         throw new NullPointerException("player nie może być null");
        }else {
            this.player.add(player);
        }
    }

//    public Waist getWaist(int id) {
//        for (Waist waist :waist) {
//            if(waist = )
//        }
//        return waist;
//    }

    private void setWaist(Waist waist) {
        if(waist == null){
            throw new NullPointerException("kibic nie może być null");
        }else {
            this.waist.add(waist);
        }
    }

    public boolean hasWaist(Waist waist){
        return this.waist.contains(waist);
    }
}
