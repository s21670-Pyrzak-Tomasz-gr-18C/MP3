package com.pyrzakt.overlappingkompozycja;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {

    private String firstName;
    private String lastName;
    private String teamName;
    private Set<Player> players; //Kompozycja całość liczność *
    private Set<Waist> waists;   //Kompozycja całość liczność *

    private static Set<Person> persons = new HashSet<>();

    public Person(String firstName, String lastName, String teamName) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        this.players = new HashSet<Player>();
        this.waists = new HashSet<Waist>();
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

    public void addWaist(Waist waist){
        if(!waists.contains(waist)){
            this.waists.add(waist);
        }
    }

    public void addPlayer(Player player){
        if(!players.contains(player)){
            this.players.add(player);
        }
    }

    public Player getPlayer(int iD) throws Exception {
        for (Player player: players) {
            if (player.iD==iD){
                return  player;
            }
        }
        throw new Exception("Nie znaleziono zawodnika o podanym id");
    }
    public Waist getWaist(int iD) throws Exception {
        for (Waist waist: waists) {
            if(waist.iD == iD){
                return waist;
            }
        }
        throw new Exception("Nie znaleziono kibica o podanym id");
    }

    public boolean removePlayer(Player player) throws Exception {
        if(player!= null && hasPlayer(player)){
            Player.removePlayer(player);
            return true;
        }
        return false;
    }
    public boolean removeWaist(Waist waist) throws Exception {
        if(waist!= null && hasWaist(waist)){
            Waist.removeWaist(waist);
            return true;
        }
        return false;
    }

    public boolean hasWaist(Waist waist){
        return this.waists.contains(waist);
    }
    public boolean hasPlayer(Player player){
        return this.waists.contains(player);
    }


}
