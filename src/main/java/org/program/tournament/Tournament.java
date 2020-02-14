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
//    public FighterList startTournament(FighterList tour) {
//        Fighter player1;
//        Fighter player2;
//        FighterList nextRound = new FighterList();
//
//        while (tour.getListSize() != 0) {
//            int getPlayer = 0;
//            player1 = tour.getAFighter(getPlayer);
//            tour.removeFromTournament(tour.getAFighter(getPlayer));
//            player2 = tour.getAFighter(getPlayer);
//            tour.removeFromTournament(tour.getAFighter(getPlayer));
//            int player1wins = 0;
//            int player2wins = 0;
//            for (int i = 1; i < 4; i++) {
//                boolean playerIsDead = false;
//                //sätt in en switch-case så att spelaren måste starta omgången med ett knapptryck
//                System.out.println("Round: " + i);
//                while (playerIsDead == false) {
//                    //Här läggs scanner till
//                    int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                    int playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                    player2.defend(playerDefence, player1.attack(playerAttack));
//                    if (player2.getHp() > 0) {
//                        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                        player1.defend(playerDefence, player2.attack(playerAttack));
//                    }
//                    if (player2.getHp() <= 0) {
//                        player1wins += 1;
//                        playerIsDead = true;
//                    } else if (player1.getHp() <= 0) {
//                        player2wins += 1;
//                        playerIsDead = true;
//                    }
//                }
//                //Återställer hp till nästa rond. MÅSTE FINNAS BÄTTRE SÄTT!
//                player1.setHp(100);
//                player2.setHp(100);
//            }
//            if (player1wins > player2wins) {
//                System.out.println(player1.getName() + ": \"" + player1.getQuote() + "\"");
//                nextRound.addToTournament(player1);
//            } else if (player2wins > player1wins) {
//                System.out.println(player2.getName() + ": \"" + player2.getQuote() + "\"");
//                nextRound.addToTournament(player2);
//            } else {
//                System.out.println("Something went wrong in the fight");
//            }
//        }
//        return nextRound;
//    }
    public FighterList startTournament(FighterList tour) {
        Fighter player1;
        Fighter player2;
        FighterList nextRound = new FighterList();

        while (tour.getListSize() != 0) {
            int getPlayer = 0;
            player1 = tour.getAFighter(getPlayer);
            tour.removeFromTournament(tour.getAFighter(getPlayer));
            player2 = tour.getAFighter(getPlayer);
            tour.removeFromTournament(tour.getAFighter(getPlayer));
            int player1wins = 0;
            int player2wins = 0;
            for (int i = 1; i < 4; i++) {
                boolean playerIsDead = false;
                //sätt in en switch-case så att spelaren måste starta omgången med ett knapptryck
                System.out.println("Round: " + i);
                while (playerIsDead == false) {
                    //Här läggs scanner till
                    int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
                    int playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
                    player2.defend(playerDefence, player1.attack(playerAttack));
                    if (player2.getHp() > 0) {
                        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
                        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
                        player1.defend(playerDefence, player2.attack(playerAttack));
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
