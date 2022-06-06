package com.pyrzakt.dziedziczeniedynamicznekompozycja;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private double salary;
    protected int iD;
    private static int counter;
    private Person person;

    private static Set<Player> players = new HashSet<>();

    public Player(double salary, Person person) {
        setPerson(person);
        setSalary(salary);
        counter++;
        setiD(counter);
        players.add(this);
    }
    //gettery settery atrybutów


    public Person getPerson() {
        return person;
    }


    public Player getPlayer(int id) throws Exception {
        for (Player player: players) {
            if(player.iD == id){
                return player;
            }
        }
        throw new Exception("Nie znalezionozawodnika o podanym id");
    }

    private void setiD(int counter) {
        this.iD = counter;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary<=0){
            throw new IllegalArgumentException("Niepoprawna wartość zarobków");
        }else {
            this.salary = salary;
        }
    }

    // obsługa ekstensji
    public static List<Player> getPlayers() {
        return java.util.Collections.unmodifiableList(players.stream().collect(Collectors.toList()));
    }

    public static boolean removePlayer(Player player) throws Exception{
        if(player == null || !players.contains(player)){
            return false;
        }
        if(player.getPerson().getPlayer().equals(player)){
            players.remove(player);
            player.getPerson().removePlayer(player);
            return true;
        }
        return false;
    }

    private void setPerson(Person person){
        if(person.getWaist()!=null){
            person.setWaist(null);
        }
        this.person = person;
        person.setPlayer(this);
    }

    @Override
    public String toString() {
        return "Player{" +
                "salary=" + salary +
                ", iD=" + iD +
                '}';
    }
}
