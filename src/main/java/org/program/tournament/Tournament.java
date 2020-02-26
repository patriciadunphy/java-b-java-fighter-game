package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.ui.InputHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    TournamentList list = new TournamentList();

    public Tournament() throws SQLException {
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
        List<Fighter> nextRound = new ArrayList<>();

        while (fighters.size() != 0) {
            List<Fighter> toNextMatch = new ArrayList<>();
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
            controller.printStartFight();
            switch (input.getIntInput()) {
                case 1:
                    int i = runMatchSets(toNextMatch);
                    controller.printWinnerOfMatch(i);
                    nextRound.add(controller.getAFighter(i));
                    break;
                case 0:
                    controller.printQuit();
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        return nextRound;
    }
    public int runMatchSets(List<Fighter> twoFighters) throws SQLException {
        View view = new View();
        Controller controller = new Controller(twoFighters, view);
        int player0wins = 0;
        int player1wins = 0;
        int winner;
        InputHandler input = new InputHandler();

        for (int i = 1; i < 4; i++) {
            controller.printRunMatchSetsMenu(i);
            switch (input.getIntInput()) {
                case 1:
                    controller.printStartRound(i);
                    winner = startMatch(twoFighters);
                    if (winner == 0) {
                        player0wins += 1;
                    } else if (winner == 1) {
                        player1wins += 1;
                    } else {
                        controller.printErrorMessage();
                    }
                    //If a player wins two rounds in a row there will be no 3rd round
                    if (player0wins == 2 || player1wins == 2) {
                        i = 4;
                    }
                    break;
                case 0:
                    controller.printQuit();
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        if (player0wins > player1wins) {
            return 0;
        } else
            return 1;
    }
    public int startMatch(List<Fighter> twoFighters) throws SQLException {
        View view = new View();
        Controller controller = new Controller(twoFighters, view);
        boolean playerIsDefeated = false;
        int playerwins = 2;

        while (!playerIsDefeated) {
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
                    //Swapping places
                    matchLoop(controller.getAFighter(1), controller.getAFighter(0));

                    if (controller.getAFighter(0).getHp()<=0){
                        playerwins = 1;
                        controller.printDefeat(0);
                        playerIsDefeated = true;
                    }
                }
            }
        }
        controller.resetHp(0);
        controller.resetHp(1);
        return playerwins;
    }
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
        if (controller.getHp(1) < controller.getHp(0)){
            rand = (int) (Math.random() * (-1 - 2)) + 2;
            //If random number is more than 0 the attack will be blocked
            if (rand > 0) {
                controller.attack(0, playerAttack);
                controller.defend(1, playerDefence);
            } else {
                controller.receiveAttack(1, controller.attack(0, playerAttack));
            }
        } else {
            controller.receiveAttack(1, controller.attack(0, playerAttack));
        }
    }
}
