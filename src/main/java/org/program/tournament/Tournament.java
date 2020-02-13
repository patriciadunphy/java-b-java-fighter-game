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

    public void startTournament(FighterList tour) {
        //int listSize = tour.getListSize();
        Fighter player1;
        Fighter player2;

        while (tour.getListSize() != 0) {
            //Skapar ett random nummer mellan 0 och tour-listans storlek
            int iPlayer1 = (int) (Math.random() * (tour.getListSize()));
            //Skapar ett nytt fighter-objekt och kopierar in fightern som finns på positionen iPlayer1
            player1 = tour.getAFighter(iPlayer1);
            //Tar bort fightern från tour-listan
            tour.removeFromTournament(tour.getAFighter(iPlayer1));
            //Gör detsamma för player2
            int iPlayer2 = (int) (Math.random() * (tour.getListSize()));
            player2 = tour.getAFighter(iPlayer2);
            tour.removeFromTournament(tour.getAFighter(iPlayer2));
            int player1wins = 0;
            int player2wins = 0;
            //loop för tre ronder
            for (int i = 1; i < 4; i++) {

                boolean playerIsDead = false;
                System.out.println("Round: " + i);
                while (playerIsDead == false) {
                    //Här läggs scanner till
                    int playerDefence;
                    int playerAttack;
                    //player1 attackerar player2
                    player2.defend(playerDefence = 2, player1.attack(playerAttack = 1));
                    //om player2 inte är död attackerar player2
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
                System.out.println("player1 läggs till i ny lista");
                //lägg till player1 i ny lista
            } else if (player2wins > player1wins) {
                System.out.println("player2 läggs till i ny lista");
                //lägg till player2 i ny lista
            } else {
                System.out.println("Something went wrong in the fight");
            }


        }
    }
}
