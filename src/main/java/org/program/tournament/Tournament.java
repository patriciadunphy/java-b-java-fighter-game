package org.program.tournament;

import org.program.db.SQLDatabase;
import org.program.fighter.Fighter;
import org.program.ui.InputHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {
    //Call the database, gets fighters och places them in a list, the list is returned
    public List<Fighter> createTournamentList() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        List<Fighter> fighters = new ArrayList<Fighter>();
        //---Fetching fighters from db and putting them in Tournament Fighters list---
        fighters.addAll(db.getFighters());
        db.closeConnection(db.getConnection());
        //Shuffles the fighters in the list
        Collections.shuffle(fighters);
        return fighters;
    }

    //    //Creates to lists, the first one inludes the fighters from the database
//    public void runTournament() throws SQLException {
//        List<Fighter> firstRun = createTournamentList();
//        List<Fighter> secondRun = new ArrayList<Fighter>();
//        Tournament match = new Tournament();
//
//        TournamentView view = new TournamentView();
//        TournamentController controller = new TournamentController(firstRun, view);
//        //Ska en ny view startas här?
////        TournamentView secondView = new TournamentView();
////        TournamentController secondController = new TournamentController(secondRun, secondView);
//
//        //As long as either the first or second list has two or more fighters
//        while (firstRun.size() >= 2 || secondRun.size() >= 2) {
//            //Print match list: NYTT:
//            controller.printMatchList();
//            //Creates a new tournament of the first list, the winners that are returned as a list are placed
//            //in the secondRun list
//            secondRun = match.createNewTournament(firstRun);
//            if (secondRun.size() >= 2) {
//                //If the secondRun list is equal to or more than two the above method is repeated
//                firstRun = match.createNewTournament(secondRun);
//
//                //NEW
//                view = new TournamentView();
//                controller = new TournamentController(secondRun, view);
//
//                //print match list: NYTT:
//                //secondController.printMatchList();
//            }
//        }
//        if (secondRun.size() == 0) {
//            System.out.println("The winner of the tournament is: ");
//            System.out.println(firstRun.get(0).getName());
//            firstRun.get(0).updateWins();
//        } else {
//            System.out.println("The winner of the tournament is: ");
//            System.out.println(secondRun.get(0).getName());
//            secondRun.get(0).updateWins();
//        }
//    }
//Creates to lists, the first one inludes the fighters from the database
    public void runTournament() throws SQLException {
        List<Fighter> firstRun = createTournamentList();
        Tournament match = new Tournament();

        TournamentView view = new TournamentView();
        TournamentController controller = new TournamentController(firstRun, view);

        //As long as the list has two or more fighters
        while (firstRun.size() >= 2) {
            controller.updateMatchList(firstRun);
            controller.printMatchList();
            //Creates a new tournament of the list, the winners that are returned as a list.

            firstRun = match.createNewTournament(firstRun);
            //Only the winners are returned to the list after the method createNewTournament has been executed

        }
            System.out.println("The winner of the tournament is: ");
            System.out.println(firstRun.get(0).getName());
            firstRun.get(0).updateWins();
    }

    public List<Fighter> createNewTournament(List<Fighter> tour) throws SQLException {
        Fighter player0;
        Fighter player1;
        InputHandler input = new InputHandler();
        List<Fighter> nextRound = new ArrayList<Fighter>();

        while (tour.size() != 0) {
            int getPlayer = 0;
            player0 = tour.get(getPlayer);
            tour.remove(tour.get(getPlayer));
            player1 = tour.get(getPlayer);
            tour.remove(tour.get(getPlayer));

            System.out.println("Coming up: " + player0.getName() + " VS. " + player1.getName());

            System.out.println("1: Start fight\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    Fighter winnerOfFight = runThreeMatches(player0, player1);
                    System.out.println("Winner: " + winnerOfFight.getName() + ": \"" + winnerOfFight.getQuote() + "\"");
                    nextRound.add(winnerOfFight);
                    break;
                case 0:
                    System.out.println("Quitting");
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        return nextRound;
    }

    public Fighter runThreeMatches(Fighter player0, Fighter player1) throws SQLException {
        Match match = new Match();
        int player0wins = 0;
        int player1wins = 0;
        int winner;
        InputHandler input = new InputHandler();

        for (int i = 1; i < 4; i++) {
            System.out.println("1: Start round " + i + "\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    System.out.println("Round " + i);
                    winner = match.startMatch(player0, player1);
                    if (winner == 0) {
                        player0wins += 1;
                    } else if (winner == 1) {
                        player1wins += 1;
                    } else {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 0:
                    System.out.println("Quitting");
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        if (player0wins > player1wins) {
            return player0;
        } else
            return player1;
    }
}
