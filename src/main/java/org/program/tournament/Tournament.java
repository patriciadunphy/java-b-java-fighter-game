package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.ui.InputHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    /**
     * Creating a new tournament list
     */
    TournamentList list = new TournamentList();

    public Tournament() throws SQLException {
    }

    /**
     * Starts the tournament
     * @throws SQLException
     */
    public void runTournament() throws SQLException {
        View view = new View();
        List<Fighter> fighters = list.getTournamentList();
        Controller controller = new Controller(fighters, view);

        while (controller.getSize() >= 2) {
            controller.printMatchList();
            /**
             * Creating a new tournament of the list, the winners are returned as a list.
             * The list will decrease by half for each time this method is invoked
             */
            fighters = createNewTournament(fighters);
            /**
             * Only the winners are returned to the list after the method createNewTournament has been executed
             */
            controller.updateMatchList(fighters);
        }
        controller.updateMatchList(fighters);
        controller.printWinner();
        /**
         * Updating wins (for the only fighter left in the list) in the database
         */
        controller.updateWins(0);
    }

    /**
     * Retrieving and removing two fighters from the fighters list
     * @param fighters
     * @return nextRound
     * @throws SQLException
     */
    public List<Fighter> createNewTournament(List<Fighter> fighters) throws SQLException {
        InputHandler input = new InputHandler();
        List<Fighter> nextRound = new ArrayList<>();

        while (fighters.size() != 0) {
            List<Fighter> toNextMatch = new ArrayList<>();
            View view = new View();
            Controller controller = new Controller(toNextMatch, view);
            int getPlayer = 0;
            /**
             * Adding fighter on index 0 to list toNextMatch
             */
            toNextMatch.add(fighters.get(getPlayer));
            /**
             * Removing fighter from fighters
             */
            fighters.remove(fighters.get(getPlayer));
            toNextMatch.add(fighters.get(getPlayer));
            fighters.remove(fighters.get(getPlayer));
            /**
             * Updating controller
             */
            controller.updateMatchList(toNextMatch);
            /**
             * Printing from controller
             */
            controller.printNextMatch();
            controller.printStartFight();
            switch (input.getIntInput()) {
                case 1:
                    /**
                     * Running runMatchSets method which returns the number of the winner of the match(0 or 1)
                     */
                    int i = runMatchSets(toNextMatch);
                    controller.printWinnerOfMatch(i);
                    /**
                     *Adding the winner to the nextRound list
                     */
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

    /**
     * Runs three matches (two if the same fighter wins the two first rounds)
     * @param twoFighters
     * @return the index number of the winner of three matches
     * @throws SQLException
     */
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
                    /**
                     * Running the runMatchChecker method
                     */
                    winner = runMatch(twoFighters);
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

    /**
     * Method for checking when an attack should take place and to check if a player is dead
     * @param twoFighters
     * @return playerwins
     * @throws SQLException
     */
    public int runMatch(List<Fighter> twoFighters) throws SQLException {
        View view = new View();
        Controller controller = new Controller(twoFighters, view);
        boolean playerIsDefeated = false;
        int playerwins = 2;
        /**
         * As long as a player isn't defeated each fighter will take a turn
         */
        while (!playerIsDefeated) {
            /**
             * Player 0 takes it turn
             */
            attack(controller.getAFighter(0), controller.getAFighter(1));
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
                    /**
                     * Swapping places on the fighter: player 1 takes it turn
                     */
                    attack(controller.getAFighter(1), controller.getAFighter(0));

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

    /**
     * Method for a fighter to attack another fighter
     * The attacks and defence methods are chosen at random
     * If the defender's hp is lower that the attacker's there's a 1 in 3 chance for them to block the attack
     * @param attacker
     * @param defender
     */
    private void attack(Fighter attacker, Fighter defender) {
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
            /**
             * If random number is more than 0 the attack will be blocked
             */
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
