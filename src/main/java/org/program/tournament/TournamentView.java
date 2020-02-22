package org.program.tournament;

import org.program.fighter.Fighter;
import java.util.List;

public class TournamentView {
    public void printMatchList(List<Fighter> fighters) {
        int i = 1;
        System.out.println("----------------------------");
        System.out.println("UPCOMING MATCHES");
        for (Fighter fighter : fighters) {
            if (i % 2 != 0)
                System.out.print(fighter.getName() + " VS. ");
            else {
                System.out.println(fighter.getName());
            }
            i += 1;
        }
        System.out.println("----------------------------");
    }
    public void printWinner(List<Fighter> fighters){
        System.out.println("----------------------------");
        System.out.println("The winner of the tournament is: ");
        System.out.println(fighters.get(0).getName());
        System.out.println("----------------------------");
    }
    public void printNextMatch(List<Fighter> fighters){
        System.out.println("Coming up: " + fighters.get(0).getName() + " VS. " + fighters.get(1).getName());
    }
}
