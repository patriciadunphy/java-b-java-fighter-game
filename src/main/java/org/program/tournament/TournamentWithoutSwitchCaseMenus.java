//package org.program.tournament;
//
//import org.program.fighter.Fighter;
//import org.program.fighter.FighterList;
//import java.sql.SQLException;
//
//public class TournamentWithoutSwitchCaseMenus {
//    public void runTournament() throws SQLException {
//        FighterList firstRun = new FighterList();
//        FighterList secondRun = new FighterList();
//        Tournament match = new Tournament();
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
//            System.out.println("Coming up: "+ player0.getName()+" VS. "+player1.getName());
//
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
//        int winner;
//
//        for (int i = 1; i < 4; i++) {
//            System.out.println("Round "+i);
//            winner = tournamentRound(player0, player1);
//            if (winner == 0) {
//                player0wins += 1;
//            } else if (winner == 1) {
//                player1wins += 1;
//            } else {
//                System.out.println("Something went wrong");
//            }
//        }
//        if (player0wins > player1wins) {
//            return player0;
//        } else
//            return player1;
//
//
//    }
//
//    public int tournamentRound(Fighter player0, Fighter player1) throws SQLException {
//        boolean playerIsDefeated = false;
//        int playerAttack;
//        int playerDefence;
//        int rand;
//        int playerwins = 2;
//
//        while (!playerIsDefeated) {
//            playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//            playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//
//            if (player1.getHp() < player0.getHp()) {
//                rand = (int) (Math.random() * (-1 - 2)) + 2;
//                if (rand > 0) {
//                    player0.attack(playerAttack);
//                    player1.defend(playerDefence);
//                } else {
//                    player1.receiveAttack(player0.attack(playerAttack));
//                }
//            } else {
//                player1.receiveAttack(player0.attack(playerAttack));
//            }
//            if (player0.getHp() <= 0) {
//                playerwins = 1;
//                playerIsDefeated = true;
//                System.out.println(player0.getName()+" is defeated");
//            } else {
//                if (player1.getHp() <= 0) {
//                    playerwins = 0;
//                    playerIsDefeated = true;
//                    System.out.println(player1.getName()+" is defeated");
//                } else {
//                    playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//                    playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//                    if (player0.getHp() < player1.getHp()) {
//                        rand = (int) (Math.random() * (-1 - 2)) + 2;
//                        if (rand > 0) {
//                            player1.attack(playerAttack);
//                            player0.defend(playerDefence);
//                        } else {
//                            player0.receiveAttack(player1.attack(playerAttack));
//                        }
//                    } else {
//                        player0.receiveAttack(player1.attack(playerAttack));
//                    }
//                    if (player0.getHp() <= 0) {
//                        playerwins = 1;
//                        playerIsDefeated = true;
//                        System.out.println(player0.getName()+" is defeated");
//                    }
//                }
//            }
//        }
//        player0.resetHp();
//        player1.resetHp();
//        return playerwins;
//    }
//}
//
//
//
