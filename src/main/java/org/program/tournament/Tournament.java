package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.fighter.FighterList;

public class Tournament {
    /*
    public void
    Du måste också skapa en matchklass, det här är
    klassen som är ansvarig för att skapa en match
    mellan två Fighter's i turneringen.
     */
    /*
     *Rapportera via terminalen det kommande slaget, fighter name vs fighter name till exempel
     *Ett kommandoradsinterface för att starta en kamp och varje runda.
     *Tre slagrunder och rekord vilken fighter som vann varje omgång.
     *Bäst av tre omgångar logik för att bestämma vinnaren.
     *Uppdatera turneringen med den vinnande kämpen.
     *Skriv i terminalen mottoet för den vinnande fighter.

     */
    public FighterList startTournament(FighterList tour) {
        Fighter player1;
        Fighter player2;
        FighterList nextRound = new FighterList();

        while (tour.getListSize() != 0) {
            int iPlayer1 = 0;
            player1 = tour.getAFighter(iPlayer1);
            tour.removeFromTournament(tour.getAFighter(iPlayer1));
            int iPlayer2 = 0;
            player2 = tour.getAFighter(iPlayer2);
            tour.removeFromTournament(tour.getAFighter(iPlayer2));
            int player1wins = 0;
            int player2wins = 0;
            for (int i = 1; i < 4; i++) {

                boolean playerIsDead = false;
                System.out.println("Round: " + i);
                while (playerIsDead == false) {
                    //Här läggs scanner till
                    int playerDefence;
                    int playerAttack;
                    player2.defend(playerDefence = 2, player1.attack(playerAttack = 1));
                    if (player2.getHp() > 0) {
                        player1.defend(playerDefence = 2, player2.attack(playerAttack = 2));
                    }
                    if (player2.getHp() <= 0) {
                        player1wins += 1;
                        playerIsDead = true;
                    } else if (player1.getHp() <= 0) {
                        player2wins += 1;
                        playerIsDead = true;
                    }
                }
                //Återställer hp till nästa rond. MÅSTE FINNAS BÄTTRE SÄTT!
                player1.setHp(100);
                player2.setHp(100);
            }
            if (player1wins > player2wins) {
                System.out.println(player1.getName() + ": \"" + player1.getQuote() + "\"");
                nextRound.addToTournament(player1);
            } else if (player2wins > player1wins) {
                System.out.println(player2.getName() + ": \"" + player2.getQuote() + "\"");
                nextRound.addToTournament(player2);
            } else {
                System.out.println("Something went wrong in the fight");
            }
        }
        return nextRound;
    }
}
