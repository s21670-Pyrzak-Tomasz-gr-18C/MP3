package com.pyrzakt.wieloaspektowe;

import com.pyrzakt.overlappingkompozycja.Waist;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private String firstName;
    private String lastName;
    private String teamName;
    private double salary;
    private ExperienceLevel experienceLevel; //kompozycja

    private static Set<Player> players = new HashSet<>();

    public Player(String firstName, String lastName, String teamName,double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setTeamName(teamName);
        setSalary(salary);
        players.add(this);
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Niepoprawna wartość zarobków");
        } else {
            this.salary = salary;
        }
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

    //kompozycja obsługa

    public void addExperience(ExperienceLevel experienceLevel){
            this.experienceLevel = experienceLevel;
    }

    public boolean removeExperience(ExperienceLevel experienceLevel) throws Exception {
        if(experienceLevel!= null && !this.experienceLevel.equals(experienceLevel)){
            ExperienceLevel.removeExperienceLevel(experienceLevel);
            return true;
        }
        return false;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }



    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", salary=" + salary +
                ", experienceLevel=" + experienceLevel +
                '}';
    }
}
