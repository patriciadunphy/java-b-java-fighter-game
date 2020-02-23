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
        int playerAttack;
        int playerDefence;
        int rand;
        int playerwins = 2;

        while (!playerIsDefeated) {
            playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
            playerDefence = (int) (Math.random() * (-1 - 2)) + 2;

            if (player1Controller.getHp() < player0Controller.getHp()) {
                rand = (int) (Math.random() * (-1 - 2)) + 2;
                if (rand > 0) {
                    player0Controller.attack(playerAttack);
                    player1Controller.defend(playerDefence);
                } else {
                   player1Controller.receiveAttack(player0Controller.attack(playerAttack));
                }
            } else {
                player1Controller.receiveAttack(player0Controller.attack(playerAttack));
            }
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
                    playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
                    playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
                    if (player0Controller.getHp() < player1Controller.getHp()) {
                        rand = (int) (Math.random() * (-1 - 2)) + 2;
                        if (rand > 0) {
                            player1Controller.attack(playerAttack);
                            player0Controller.defend(playerDefence);
                        } else {
                            player0Controller.receiveAttack(player1Controller.attack(playerAttack));
                        }
                    } else {
                        player0Controller.receiveAttack(player1Controller.attack(playerAttack));
                    }
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
