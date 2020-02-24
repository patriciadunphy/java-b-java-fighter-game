//package org.program.tournament;
//
//import org.program.fighter.Fighter;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class Match {
//
//    Controller controller;
//
//    public int startMatch(List<Fighter> twoFighters) throws SQLException {
//        boolean playerIsDefeated = false;
//        int playerwins = 2;
//
//        while (!playerIsDefeated) {
//            //Running matchLoop method
//            matchLoop(twoFighters);
////            if (twoFighters.get(0).getHp() <= 0) {
//            if (twoFighters.get(0).getHp() <= 0) {
//                playerwins = 1;
//                playerIsDefeated = true;
//                System.out.println(twoFighters.get(0).getName() + " is defeated");
//            } else {
//                if (twoFighters.get(1).getHp() <= 0) {
//                    playerwins = 0;
//                    playerIsDefeated = true;
//                    System.out.println(twoFighters.get(1).getName() + " is defeated");
//                } else {
//                    matchLoop(twoFighters);
//                    if (twoFighters.get(0).getHp() <= 0) {
//                        playerwins = 1;
//                        playerIsDefeated = true;
//                        System.out.println(twoFighters.get(0).getName() + " is defeated");
//                    }
//                }
//            }
//        }
//        twoFighters.get(0).resetHp();
//        twoFighters.get(1).resetHp();
//        return playerwins;
//    }
//
//    private void matchLoop(List<Fighter> twoFighters) {
//        int playerAttack;
//        int playerDefence;
//        int rand;
//        playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
//        playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
//        if (twoFighters.get(1).getHp() < twoFighters.get(0).getHp()) {
//            rand = (int) (Math.random() * (-1 - 2)) + 2;
//            //If random number is more than 0 the attack will be blocked
//            if (rand > 0) {
//                twoFighters.get(0).attack(playerAttack);
//                twoFighters.get(1).defend(playerDefence);
//            } else {
//                twoFighters.get(1).receiveAttack(twoFighters.get(0).attack(playerAttack));
//            }
//        } else {
//            twoFighters.get(1).receiveAttack(twoFighters.get(0).attack(playerAttack));
//        }
//    }
//}
