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

    //Creates to lists, the first one inludes the fighters from the database
    public void runTournament() throws SQLException {
        List<Fighter> fighters = createTournamentList();
        Tournament match = new Tournament();

        TournamentView view = new TournamentView();
        TournamentController controller = new TournamentController(fighters, view);

        //As long as the list has two or more fighters
        while (fighters.size() >= 2) {
            //Update controller with existing fighters in list
            controller.updateMatchList(fighters);
            //Controller prints fighters
            controller.printMatchList();
            //Creates a new tournament of the list, the winners that are returned as a list.
            fighters = match.createNewTournament(fighters);
            //Only the winners are returned to the list after the method createNewTournament has been executed
        }
        controller.updateMatchList(fighters);
        controller.printWinner();
        //Updating wins in database
        fighters.get(0).updateWins();
    }

    public List<Fighter> createNewTournament(List<Fighter> tour) throws SQLException {
        InputHandler input = new InputHandler();
        List<Fighter> nextRound = new ArrayList<Fighter>();

        while (tour.size() != 0) {
            List<Fighter> toNextMatch = new ArrayList<Fighter>();
            TournamentView view = new TournamentView();
            TournamentController controller = new TournamentController(toNextMatch, view);
            int getPlayer = 0;
            //Adding fighter on index 0 to list toNextMatch
            toNextMatch.add(tour.get(getPlayer));
            //Removing fighter from tour
            tour.remove(tour.get(getPlayer));
            toNextMatch.add(tour.get(getPlayer));
            tour.remove(tour.get(getPlayer));
            //Updating controller
            controller.updateMatchList(toNextMatch);
            //Printing from controller
            controller.printNextMatch();

            System.out.println("1: Start fight\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    Fighter winnerOfFight = runMatchSets(toNextMatch);
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

    public Fighter runMatchSets(List<Fighter> toNextMatch) throws SQLException {
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
                    winner = match.startMatch(toNextMatch);
                    if (winner == 0) {
                        player0wins += 1;
                    } else if (winner == 1) {
                        player1wins += 1;
                    } else {
                        System.out.println("Something went wrong");
                    }
                    //If a player wins two rounds in a row there will be no 3rd round
                    if (player0wins == 2 || player1wins == 2){
                        i = 4;
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
            return toNextMatch.get(0);
        } else
            return toNextMatch.get(1);
    }
}