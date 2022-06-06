package com.pyrzakt.wieloaspektowe;

import java.util.HashSet;
import java.util.Set;

public class Junior extends ExperienceLevel{

    private static Set<Junior> juniors = new HashSet<>();

    public Junior(int numberOfPlayedMatches, Player player) {
        super(numberOfPlayedMatches, player);
        juniors.add(this);
    }

    public boolean sendForAdditionalTraining(){
        System.out.println("Zawodnik wysłany na dodatkowy trening");
        return true;
    }


    @Override
    public String toString() {
        return "Junior z junior{" +
                "iD=" + iD +
                '}';
    }
}
