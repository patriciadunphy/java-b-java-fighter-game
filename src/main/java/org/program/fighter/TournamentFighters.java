package org.program.fighter;

import java.util.ArrayList;
import java.util.List;

public class TournamentFighters {
    private List<Fighter> fighters = new ArrayList<Fighter>();

    public void addToTournament(Fighter fighter){
        this.fighters.add(fighter);
    }
    public void removeFromTournament(Fighter fighter){
        this.fighters.remove(fighter);
    }
    public List<Fighter> getFighters() {
        return fighters;
    }
    public void insertFightersFromDb(List<Fighter> fighters){
        this.fighters.addAll(fighters);
    }
    public void updateFighterInList(int i,Fighter fighter){
        this.fighters.set(i, fighter);
    }

    public void printFightersList(){
        for (Fighter fighter : this.fighters){
            System.out.println(fighter);
        }
    }
    //Create observer and observe when a fighter is removed from tournament due to losing?
}
