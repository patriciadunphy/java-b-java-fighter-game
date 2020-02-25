package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.ui.InputHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewTournament {
    Controller controller;
    TournamentList list = new TournamentList();

    public NewTournament() throws SQLException {
    }

    public void runTournament() throws SQLException {
        View view = new View();
        List<Fighter> fighters = list.getTournamentList();
        Controller controller = new Controller(fighters, view);

        while (controller.getSize() >= 2) {
            controller.printMatchList();
            //Creates a new tournament of the list, the winners are returned as a list.
            fighters = createNewTournament(fighters);
            //Only the winners are returned to the list after the method createNewTournament has been executed
            controller.updateMatchList(fighters);
        }
        controller.updateMatchList(fighters);
        controller.printWinner();
        //Updating wins (for the only fighter left in the list) in database
        controller.updateWins(0);
    }

    public List<Fighter> createNewTournament(List<Fighter> fighters) throws SQLException {
        InputHandler input = new InputHandler();
        List<Fighter> nextRound = new ArrayList<Fighter>();

        while (fighters.size() != 0) {
            List<Fighter> toNextMatch = new ArrayList<Fighter>();
            View view = new View();
            Controller controller = new Controller(toNextMatch, view);
            int getPlayer = 0;
            //Adding fighter on index 0 to list toNextMatch
            toNextMatch.add(fighters.get(getPlayer));
            //Removing fighter from fighters
            fighters.remove(fighters.get(getPlayer));
            toNextMatch.add(fighters.get(getPlayer));
            fighters.remove(fighters.get(getPlayer));
            //Updating controller
            controller.updateMatchList(toNextMatch);
            //Printing from controller
            controller.printNextMatch();

            System.out.println("1: Start fight\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    int i = runMatchSets(toNextMatch);
                    controller.printWinnerOfMatch(i);
//                    System.out.println("Winner: " + winnerOfFight.getName() + ": \"" + winnerOfFight.getQuote() + "\"");
                    nextRound.add(controller.getAFighter(i));
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

    //    public Fighter runMatchSets(List<Fighter> twoFighters) throws SQLException {
    public int runMatchSets(List<Fighter> twoFighters) throws SQLException {
        //Match match = new Match();
        int player0wins = 0;
        int player1wins = 0;
        int winner;
        InputHandler input = new InputHandler();

        for (int i = 1; i < 4; i++) {
            System.out.println("1: Start round " + i + "\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    System.out.println("Round " + i);
                    winner = startMatch(twoFighters);
                    if (winner == 0) {
                        player0wins += 1;
                    } else if (winner == 1) {
                        player1wins += 1;
                    } else {
                        System.out.println("Something went wrong");
                    }
                    //If a player wins two rounds in a row there will be no 3rd round
                    if (player0wins == 2 || player1wins == 2) {
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
//            return twoFighters.get(0);
            return 0;
        } else
//            return twoFighters.get(1);
            return 1;
    }
    public int startMatch(List<Fighter> twoFighters) throws SQLException {
        View view = new View();
        Controller controller = new Controller(twoFighters, view);
        boolean playerIsDefeated = false;
        int playerwins = 2;

        while (!playerIsDefeated) {
            //Running matchLoop method
            //matchLoop(twoFighters);
            matchLoop(controller.getAFighter(0), controller.getAFighter(1));
            if (controller.getAFighter(0).getHp() <= 0) {
                playerwins = 1;
                controller.printDefeat(0);
                playerIsDefeated = true;
            } else {
                if (controller.getAFighter(1).getHp() <= 0) {
                    playerwins = 0;
                    controller.printDefeat(1);
                    playerIsDefeated = true;
                } else {
                    //Swapping places with fighters on index 0 and 1 each time this method is run
                    //Collections.swap(twoFighters, 0, 1);

                    //DET ÄR HÄR LOGIKEN INTE FUNGERAR

                    //controller.swapPlacesOnTwoFighters();
                    //matchLoop(twoFighters);
                    //matchLoop(controller.getFighterList());
                    matchLoop(controller.getAFighter(1), controller.getAFighter(0));

                    if (controller.getAFighter(0).getHp()<=0){
                        playerwins = 1;
                        controller.printDefeat(0);
                        playerIsDefeated = true;
                    }
                    //NYTT
                    //controller.swapPlacesOnTwoFighters();
                }
            }
        }
        controller.resetHp(0);
        controller.resetHp(1);
//        twoFighters.get(0).resetHp();
//        twoFighters.get(1).resetHp();
        return playerwins;
    }

    //private void matchLoop(List<Fighter> twoFighters) {
    private void matchLoop(Fighter attacker, Fighter defender) {

    View view = new View();
        List<Fighter> twoFighters = new ArrayList<>();
        twoFighters.add(attacker);
        twoFighters.add(defender);
        Controller controller = new Controller(twoFighters, view);

        int playerAttack;
        int playerDefence;
        int rand;
        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
        //if (twoFighters.get(1).getHp() < twoFighters.get(0).getHp()) {
        if (controller.getHp(1) < controller.getHp(0)){
            rand = (int) (Math.random() * (-1 - 2)) + 2;
            //If random number is more than 0 the attack will be blocked
            if (rand > 0) {
                //twoFighters.get(0).attack(playerAttack);
                //twoFighters.get(1).defend(playerDefence);
                controller.attack(0, playerAttack);
                controller.defend(1, playerDefence);
            } else {
                //twoFighters.get(1).receiveAttack(twoFighters.get(0).attack(playerAttack));
                controller.receiveAttack(1, controller.attack(0, playerAttack));
            }
        } else {
            controller.receiveAttack(1, controller.attack(0, playerAttack));
        }
    }
}
