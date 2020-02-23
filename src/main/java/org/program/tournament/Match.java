package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.fighter.FighterController;
import org.program.fighter.FighterView;

import java.sql.SQLException;
import java.util.List;

public class Match {
    public int startMatch(List<Fighter> twoFighters) throws SQLException {
        Fighter player0 = twoFighters.get(0);
        Fighter player1 = twoFighters.get(1);

        FighterView view = new FighterView();
        FighterController player0Controller = new FighterController(player0, view);
        FighterController player1Controller = new FighterController(player1, view);

        boolean playerIsDefeated = false;
        int playerwins = 2;

        while (!playerIsDefeated) {
            //Running matchLoop method
            matchLoop(player1Controller, player0Controller);
            if (player0Controller.getHp() <= 0) {
                playerwins = 1;
                playerIsDefeated = true;
                System.out.println(player0.getName() + " is defeated");
            } else {
                if (player1Controller.getHp() <= 0) {
                    playerwins = 0;
                    playerIsDefeated = true;
                    System.out.println(player1.getName() + " is defeated");
                } else {
                    matchLoop(player0Controller, player1Controller);
                    if (player0Controller.getHp() <= 0) {
                        playerwins = 1;
                        playerIsDefeated = true;
                        System.out.println(player0.getName() + " is defeated");
                    }
                }
            }
        }
        player0.resetHp();
        player1.resetHp();
        return playerwins;
    }

    private void matchLoop(FighterController secondAttacker, FighterController firstAttacker) {
        int playerAttack;
        int playerDefence;
        int rand;
        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
        if (secondAttacker.getHp() < firstAttacker.getHp()) {
            rand = (int) (Math.random() * (-1 - 2)) + 2;
            //If random number is more than 0 the attack will be blocked
            if (rand > 0) {
                firstAttacker.attack(playerAttack);
                secondAttacker.defend(playerDefence);
            } else {
                secondAttacker.receiveAttack(firstAttacker.attack(playerAttack));
            }
        } else {
            secondAttacker.receiveAttack(firstAttacker.attack(playerAttack));
        }
    }
}
//public class Match {
//    public int startMatch(List<Fighter> twoFighters) throws SQLException {
//        Fighter player0 = twoFighters.get(0);
//        Fighter player1 = twoFighters.get(1);
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
//                System.out.println(player0.getName() + " is defeated");
//            } else {
//                if (player1.getHp() <= 0) {
//                    playerwins = 0;
//                    playerIsDefeated = true;
//                    System.out.println(player1.getName() + " is defeated");
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
//                        System.out.println(player0.getName() + " is defeated");
//                    }
//                }
//            }
//        }
//        player0.resetHp();
//        player1.resetHp();
//        return playerwins;
//    }
//}
