package com.pyrzakt.wieloaspektowe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExperienceLevel {
    private int numberOfPlayedMatches;
    protected int iD;
    private static int counter;
    private Player player;

    private static Set<ExperienceLevel> experienceLevels = new HashSet<>();


    public ExperienceLevel(int numberOfPlayedMatches, Player player) {
        setPlayer(player);
        setNumberOfPlayedMatches(numberOfPlayedMatches);
        counter++;
        setiD(counter);
        experienceLevels.add(this);
    }


    //gettery settery atrybutów


    public Player getPlayer() {
        return player;
    }


    public ExperienceLevel getExperienceLevel(int id) throws Exception {
        for (ExperienceLevel experienceLevel : experienceLevels) {
            if (experienceLevel.iD == id) {
                return experienceLevel;
            }
        }
        throw new Exception("Nie znalezionozawodnika o podanym id");
    }

    private void setiD(int counter) {
        this.iD = counter;
    }

    public int getiD() {
        return iD;
    }

    public double getNumberOfPlayedMatches() {
        return numberOfPlayedMatches;
    }

    public void setNumberOfPlayedMatches(int numberOfPlayedMatches) {
        if (numberOfPlayedMatches <= 0) {
            throw new IllegalArgumentException("Niepoprawna ilość meczy");
        } else {
            this.numberOfPlayedMatches = numberOfPlayedMatches;
        }
    }

    // obsługa ekstensji
    public static List<ExperienceLevel> getEXperienceLevels() {
        return java.util.Collections.unmodifiableList(experienceLevels.stream().collect(Collectors.toList()));
    }

    public static boolean removeExperienceLevel(ExperienceLevel experienceLevel) throws Exception {
        if (experienceLevel == null || !experienceLevel.equals(experienceLevel)) {
            return false;
        }else {
            experienceLevel.getPlayer().removeExperience(experienceLevel);
        }
            return true;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    public boolean sendForAdditionalTraining(){
        return false;
    }

    @Override
    public String toString() {
        return "ExperienceLevel{" +
                "numberOfPlayedMatches=" + numberOfPlayedMatches +
                ", iD=" + iD +
                ", player=" + player +
                '}';
    }
}
