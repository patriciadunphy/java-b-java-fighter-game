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
}
