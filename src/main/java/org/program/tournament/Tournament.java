//package org.program.tournament;
//
//import org.program.fighter.Fighter;
//import org.program.fighter.FighterList;
//
//import java.sql.SQLException;
//
//public class Tournament {
//    /*
//    public void
//    Du måste också skapa en matchklass, det här är
//    klassen som är ansvarig för att skapa en match
//    mellan två Fighter's i turneringen.
//     */
//    /*
//     *Rapportera via terminalen det kommande slaget, fighter name vs fighter name till exempel
//     *Ett kommandoradsinterface för att starta en kamp och varje runda.
//     *Tre slagrunder och rekord vilken fighter som vann varje omgång.
//     *Bäst av tre omgångar logik för att bestämma vinnaren.
//     *Uppdatera turneringen med den vinnande kämpen.
//     *Skriv i terminalen mottoet för den vinnande fighter.
//
//     */
//    public FighterList startTournament(FighterList tour) throws SQLException {
//        Fighter player0;
//        Fighter player1;
//        FighterList nextRound = new FighterList();
//
//        while (tour.getListSize() != 0) {
//            int getPlayer = 0;
//            player0 = tour.getAFighter(getPlayer);
//            tour.removeFromTournament(tour.getAFighter(getPlayer));
//            player1 = tour.getAFighter(getPlayer);
//            tour.removeFromTournament(tour.getAFighter(getPlayer));
//            int player0wins = 0;
//            int player1wins = 0;
//            for (int i = 1; i < 4; i++) {
//                FighterList currentFight = new FighterList();
//                currentFight.addToTournament(player0);
//                currentFight.addToTournament(player1);
//                boolean playerIsDefeated = false;
//                //sätt in en switch-case så att spelaren måste starta omgången med ett knapptryck
//                System.out.println("Round: " + i);
//                while (playerIsDefeated == false) {
//                    //Här läggs scanner till
//                    int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                    int playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                    currentFight.getAFighter(1).defend(playerDefence, currentFight.getAFighter(0).attack(playerAttack));
//                    if (player1.getHp() > 0) {
//                        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                        currentFight.getAFighter(0).defend(playerDefence, currentFight.getAFighter(1).attack(playerAttack));
//                    }
//                    /*
//                    Skapa slumpmässiga system (skriv logik för att se om det
//                    blir en attack eller defend), större chans att det blir
//                    en defend om fightern har lägre hp än motståndaren.
//                     */
//
//
//                    if (currentFight.getAFighter(0).getHp() <= 0) {
//                        player0wins += 1;
//                        playerIsDefeated = true;
//                    } else if (currentFight.getAFighter(1).getHp() <= 0) {
//                        player1wins += 1;
//                        playerIsDefeated = true;
//                    }
//                }
//                currentFight.getAFighter(0).resetHp();
//                currentFight.getAFighter(1).resetHp();
//            }
//            if (player0wins > player1wins) {
//                System.out.println(player0.getName() + ": \"" + player0.getQuote() + "\"");
//                nextRound.addToTournament(player0);
//            } else if (player1wins > player0wins) {
//                System.out.println(player1.getName() + ": \"" + player1.getQuote() + "\"");
//                nextRound.addToTournament(player1);
//            } else {
//                System.out.println("Something went wrong in the fight");
//            }
//        }
//        return nextRound;
//    }
//
//}
