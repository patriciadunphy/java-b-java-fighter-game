//package org.program.tournament;
//
//import org.program.fighter.Fighter;
//import org.program.fighter.FighterList;
//
//import java.sql.SQLException;
//
//public class TournamentTest {
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
//    public void runTournament() throws SQLException {
//        FighterList firstRun = new FighterList();
//        FighterList secondRun = new FighterList();
//        TournamentTest match = new TournamentTest();
//        firstRun.createMatchList();
//        while (firstRun.getListSize() >= 2 || secondRun.getListSize() >= 2) {
//            firstRun.printMatchList();
//            secondRun = match.createNewTournament(firstRun);
//            if (secondRun.getListSize() >= 2) {
//                secondRun.printMatchList();
//                firstRun = match.createNewTournament(secondRun);
//            }
//        }
//        if (secondRun.getListSize() == 0) {
//            System.out.println("The winner of the tournament is: ");
//            System.out.println(firstRun.getAFighter(0).getName());
//        } else {
//            System.out.println("The winner of the tournament is: ");
//            System.out.println(secondRun.getAFighter(0).getName());
//        }
//    }
//
//
//    public FighterList createNewTournament(FighterList tour) throws SQLException {
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
//
//            //Kör igång fight genom att anropa fight-metoden
//            Fighter winnerOfFight = fight(player0, player1);
//            System.out.println("Winner: " + winnerOfFight.getName() + ": \"" + winnerOfFight.getQuote() + "\"");
//            nextRound.addToTournament(winnerOfFight);
//        }
//        return nextRound;
//    }
//
//    public Fighter fight(Fighter player0, Fighter player1) throws SQLException {
//        int player0wins = 0;
//        int player1wins = 0;
//
//        for (int i = 1; i < 4; i++) {
//            FighterList currentFight = new FighterList();
//            currentFight.addToTournament(player0);
//            currentFight.addToTournament(player1);
//            boolean playerIsDefeated = false;
//            //sätt in en switch-case så att spelaren måste starta omgången med ett knapptryck
//
//            //Här läggs scanner till
//            System.out.println("Round: " + i);
//            while (playerIsDefeated == false) {
//                int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                int playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                int attackDamage = currentFight.getAFighter(1).getAttacks().get(playerAttack).getDamage();
//
//                //större chans att det blir en defend om fightern har
//                //lägre hp än motståndaren.
//                int hpPlayer0 = currentFight.getAFighter(0).getHp();
//                int hpPlayer1 = currentFight.getAFighter(1).getHp();
//                if (hpPlayer0 < hpPlayer1){
//                    int rand = (int) (Math.random() * (-1 - 2)) + 2;
//                    System.out.println("***PRINTING RANDOM: "+rand);
//                    if (rand > 0){
//                        currentFight.getAFighter(0).defend(playerDefence, attackDamage);
//                    }
//                    else {
//                        currentFight.getAFighter(0).setHp(currentFight.getAFighter(0).getHp()-attackDamage);
//                        currentFight.getAFighter(0).attack(playerAttack, currentFight.getAFighter(1));
//                    }
//                } else {
//                    currentFight.getAFighter(0).setHp(currentFight.getAFighter(0).getHp() - attackDamage);
//                    currentFight.getAFighter(0).attack(playerAttack, currentFight.getAFighter(1));
//                }
//                System.out.println("****SKRIVER UT HP PL0: "+(hpPlayer0));
//                System.out.println("****SKRIVER UT HP PL1: " + (hpPlayer1));
//
//                hpPlayer1 = currentFight.getAFighter(1).getHp();
//                if (hpPlayer1 < hpPlayer0) {
//                    int rand = (int) (Math.random() * (-1 - 2)) + 2;
//                    System.out.println("***PRINTING RANDOM: " + rand);
//                    if (rand > 0) {
//                        attackDamage = currentFight.getAFighter(0).getAttacks().get(playerAttack).getDamage();
//                        currentFight.getAFighter(1).defend(playerDefence, attackDamage);
//                    } else {
//                        currentFight.getAFighter(1).setHp(currentFight.getAFighter(1).getHp() - attackDamage);
//
//                        currentFight.getAFighter(1).attack(playerAttack, currentFight.getAFighter(0));
//                    }
//                } else {
//                    currentFight.getAFighter(1).setHp(currentFight.getAFighter(1).getHp() - attackDamage);
//                    currentFight.getAFighter(1).attack(playerAttack, currentFight.getAFighter(0));
//                }
//
//                if (currentFight.getAFighter(0).getHp() <= 0) {
//                    player1wins += 1;
//                    playerIsDefeated = true;
//                } else if (currentFight.getAFighter(1).getHp() <= 0) {
//                    player0wins += 1;
//                    playerIsDefeated = true;
//                }
//            }
//            currentFight.getAFighter(0).resetHp();
//            currentFight.getAFighter(1).resetHp();
//        }
//        if (player0wins > player1wins) {
//            //System.out.println(player0.getName() + ": \"" + player0.getQuote() + "\"");
//            return player0;
//        } else
//            //System.out.println(player1.getName() + ": \"" + player1.getQuote() + "\"");
//            return player1;
//
//    }
//
//}
