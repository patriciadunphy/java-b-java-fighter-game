package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.fighter.FighterList;
import org.program.ui.InputHandler;

import java.sql.SQLException;

public class Tournament {
    public void runTournament() throws SQLException {
        FighterList firstRun = new FighterList();
        FighterList secondRun = new FighterList();
        Tournament match = new Tournament();
        firstRun.createMatchList();
        while (firstRun.getListSize() >= 2 || secondRun.getListSize() >= 2) {
            firstRun.printMatchList();
            secondRun = match.createNewTournament(firstRun);
            if (secondRun.getListSize() >= 2) {
                secondRun.printMatchList();
                firstRun = match.createNewTournament(secondRun);
            }
        }
        if (secondRun.getListSize() == 0) {
            System.out.println("The winner of the tournament is: ");
            System.out.println(firstRun.getAFighter(0).getName());
        } else {
            System.out.println("The winner of the tournament is: ");
            System.out.println(secondRun.getAFighter(0).getName());
        }
    }


    public FighterList createNewTournament(FighterList tour) throws SQLException {
        Fighter player0;
        Fighter player1;
        FighterList nextRound = new FighterList();

        while (tour.getListSize() != 0) {
            int getPlayer = 0;
            player0 = tour.getAFighter(getPlayer);
            tour.removeFromTournament(tour.getAFighter(getPlayer));
            player1 = tour.getAFighter(getPlayer);
            tour.removeFromTournament(tour.getAFighter(getPlayer));

            //Kör igång fight genom att anropa fight-metoden
            Fighter winnerOfFight = fight(player0, player1);
            System.out.println("Winner: " + winnerOfFight.getName() + ": \"" + winnerOfFight.getQuote() + "\"");
            nextRound.addToTournament(winnerOfFight);
        }
        return nextRound;
    }

        public Fighter fight(Fighter player0, Fighter player1) throws SQLException {
        int player0wins = 0;
        int player1wins = 0;

        for (int i = 1; i < 4; i++) {
            FighterList currentFight = new FighterList();
            currentFight.addToTournament(player0);
            currentFight.addToTournament(player1);
            boolean playerIsDefeated = false;
            //sätt in en switch-case så att spelaren måste starta omgången med ett knapptryck
            System.out.println("Round: " + i);
            while (playerIsDefeated == false) {
                //Här läggs scanner till
                int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
                int playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
                currentFight.getAFighter(1).defend(playerDefence, currentFight.getAFighter(0).attack(playerAttack));
                if (player1.getHp() > 0) {
                    playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
                    playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
                    currentFight.getAFighter(0).defend(playerDefence, currentFight.getAFighter(1).attack(playerAttack));
                }
                    /*
                    Skapa slumpmässiga system (skriv logik för att se om det
                    blir en attack eller defend), större chans att det blir
                    en defend om fightern har lägre hp än motståndaren.
                     */


                if (currentFight.getAFighter(0).getHp() <= 0) {
                    player1wins += 1;
                    playerIsDefeated = true;
                } else if (currentFight.getAFighter(1).getHp() <= 0) {
                    player0wins += 1;
                    playerIsDefeated = true;
                }
            }
            currentFight.getAFighter(0).resetHp();
            currentFight.getAFighter(1).resetHp();
        }
        if (player0wins > player1wins) {
            //System.out.println(player0.getName() + ": \"" + player0.getQuote() + "\"");
            return player0;
        } else
            //System.out.println(player1.getName() + ": \"" + player1.getQuote() + "\"");
            return player1;

    }



}
