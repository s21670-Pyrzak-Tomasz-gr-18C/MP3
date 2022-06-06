package com.pyrzakt.wieloaspektowe;

import java.util.HashSet;
import java.util.Set;

public class Senior extends ExperienceLevel{

    private static Set<Senior> seniors = new HashSet<>();

    public Senior(int numberOfPlayedMatches, Player player) {
        super(numberOfPlayedMatches, player);
    }

    public void awardJubileeAward() throws Exception {
        this.getExperienceLevel(this.iD).getPlayer().setSalary(this.getExperienceLevel(this.iD).getPlayer().getSalary()*2);
    }

    @Override
    public String toString() {
        return "Senior{" +
                "iD=" + iD +
                '}';
    }
}
