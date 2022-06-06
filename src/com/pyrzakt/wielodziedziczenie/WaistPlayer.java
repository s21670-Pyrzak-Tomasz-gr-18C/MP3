package com.pyrzakt.wielodziedziczenie;

public class WaistPlayer extends Waist implements IPlayer{
    private double salary;

    public WaistPlayer(String firstName, String lastName, String teamName, int subscriptionNumber, int numberOfSubscriptionSeasons, double salary) {
        super(firstName, lastName, teamName, subscriptionNumber, numberOfSubscriptionSeasons);
        setSalary(salary);
        trySetVIPStatus();
    }


    @Override
    public double getSalary() {
        return salary;
    }


    @Override
    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Niepoprawna wartość zarobków");
        } else {
            this.salary = salary;
        }
    }
    public void trySetVIPStatus() {
        if(this.isVipStatus() == false) {
            this.setVipStatus(true);
        }
    }

    @Override
    public String toString() {
        return "WaistPlayer{" +
                "firstName='" + this.getFirstName() +
                ", lastName='" + this.getLastName() +
                ", teamName='" + this.getTeamName() +
                ", vipStatus='" + this.isVipStatus() +
                ", salary=" + salary +
                ", subscriptionNumber=" + this.getSubscriptionNumber() +
                '}';
    }
}
