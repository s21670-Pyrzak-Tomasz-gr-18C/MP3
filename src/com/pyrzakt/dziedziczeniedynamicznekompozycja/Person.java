package com.pyrzakt.dziedziczeniedynamicznekompozycja;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String firstName;
    private String lastName;
    private String teamName;
    private Player player; //Kompozycja całość
    private Waist waist;   //Kompozycja całość

    private static Set<Person> persons = new HashSet<>();

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


    //Obsługa kompozycji

    public void setPlayer(Player player) {
            this.player = player;

    }

    public void setWaist(Waist waist) {
            this.waist = waist;
    }

    public boolean removePlayer(Player player) throws Exception {
        if(player!= null && !this.player.equals(player)){
            Player.removePlayer(player);
            return true;
        }
        return false;
    }
    public boolean removeWaist(Waist waist) throws Exception {
        if(waist!= null && !this.waist.equals(waist)){
            Waist.removeWaist(waist);
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public Waist getWaist() {
        return waist;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", player=" + (player!=null) +
                ", waist=" + (waist!=null) +
                '}';
    }
}
