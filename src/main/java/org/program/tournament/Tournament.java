package org.program.tournament;

import org.program.db.SQLDatabase;
import org.program.fighter.Fighter;
import org.program.fighter.FighterList;
import org.program.ui.InputHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {
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
    public void runTournament() throws SQLException {

        //FighterList firstRun = new FighterList();
        //FighterList secondRun = new FighterList();
        List<Fighter> firstRun = createTournamentList();
        List<Fighter> secondRun = new ArrayList<Fighter>();
        Tournament match = new Tournament();
        //firstRun.createMatchList();
        //firstRun = createTournamentList();
        //---- NEW CODE
        TournamentView view = new TournamentView();
        TournamentController controller = new TournamentController(firstRun, view);
        //------
        while (firstRun.size() >= 2 || secondRun.size() >= 2) {
//            firstRun.printMatchList();
            //---- NEW CODE

            //------
            secondRun = match.createNewTournament(firstRun);
            if (secondRun.size() >= 2) {
//                secondRun.printMatchList();
                //---- NEW CODE

                //------
                firstRun = match.createNewTournament(secondRun);
            }
        }
        if (secondRun.size() == 0) {
            System.out.println("The winner of the tournament is: ");
            System.out.println(firstRun.get(0).getName());
            firstRun.get(0).updateWins();
        } else {
            System.out.println("The winner of the tournament is: ");
            System.out.println(secondRun.get(0).getName());
            secondRun.get(0).updateWins();
        }
    }

    public List<Fighter> createNewTournament(List<Fighter> tour) throws SQLException {
        Fighter player0;
        Fighter player1;
        InputHandler input = new InputHandler();
        //FighterList nextRound = new FighterList();
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
