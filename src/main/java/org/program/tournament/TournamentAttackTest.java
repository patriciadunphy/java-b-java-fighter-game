//package org.program.tournament;
//
//import org.program.fighter.Fighter;
//import org.program.fighter.FighterList;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TournamentAttackTest {
//    //Attack and random works. Kanske går att göra snyggare med en foreach-loop inne i while-loopen om dessa fighters ingår i en lista?
////    public void attackDefend() throws SQLException {
////        FighterList list = new FighterList();
////        list.createMatchList();
////        Fighter player0 = list.getAFighter(0);
////        Fighter player1 = list.getAFighter(1);
////        int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
////
////        player0.getHp();
////        player1.getHp();
////
////        boolean playerIsDefeated = false;
////        int playerAttack;
////        while (!playerIsDefeated) {
////            playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
////            //System.out.println("printing random: "+playerAttack);
////
////            player1.receiveAttack(player0.attack(playerAttack));
////            if (player0.getHp() <=0) {
////                playerIsDefeated = true;
////                System.out.println("player0 is defeated");
////            } else {
////                if (player1.getHp() <=0) {
////                    playerIsDefeated = true;
////                    System.out.println("player1 is defeated");
////                } else {
////                    player0.receiveAttack(player1.attack(playerAttack));
////                    if (player0.getHp()<=0){
////                        playerIsDefeated = true;
////                        System.out.println("player0 is defeated");
////                    }
////                }
////
////            }
////        }
////
////        //player1.receiveAttack(player0.attack(playerAttack));
////
////        //player1.attack(playerAttack);
////        //player0.defend(playerDefence);
////        System.out.println("player0 hp: " + player0.getHp());
////        System.out.println("player1 hp: " + player1.getHp());
////        //player1.setHp(player1.getHp()-player0.attack(playerAttack));
////
//////        System.out.println("Skriver ut player0 attack: "+player0.attack(playerAttack));
//////        System.out.println("Skriver ut player1 hp efter attack "+player1.getHp());
//////        System.out.println("Skriver ut player0 efter attack, ska vara oförändrat: "+player0.getHp());
////
////
////    }
//
//    //    public void attackDefend() throws SQLException {
////        FighterList list = new FighterList();
////        list.createMatchList();
////        Fighter player0 = list.getAFighter(0);
////        Fighter player1 = list.getAFighter(1);
////
////        boolean playerIsDefeated = false;
////        int playerAttack;
////        int playerDefence;
////        int rand;
////        while (!playerIsDefeated) {
////            playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
////            playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
////
////            if (player1.getHp() < player0.getHp()) {
////                rand = (int) (Math.random() * (-1 - 2)) + 2;
////                if (rand > 0) {
////                    player0.attack(playerAttack);
////                    player1.defend(playerDefence);
////                } else {
////                    player1.receiveAttack(player0.attack(playerAttack));
////                }
////            } else {
////                player1.receiveAttack(player0.attack(playerAttack));
////            }
////            if (player0.getHp() <= 0) {
////                playerIsDefeated = true;
////                System.out.println("player0 is defeated");
////            } else {
////                if (player1.getHp() <= 0) {
////                    playerIsDefeated = true;
////                    System.out.println("player1 is defeated");
////                } else {
////                    playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
////                    playerDefence = (int) (Math.random() * (-1 - 2)) + 2;
////                    if (player0.getHp() < player1.getHp()) {
////                        rand = (int) (Math.random() * (-1 - 2)) + 2;
////                        if (rand > 0) {
////                            player1.attack(playerAttack);
////                            player0.defend(playerDefence);
////                        } else {
////                            player0.receiveAttack(player1.attack(playerAttack));
////                        }
////                    } else {
////                        player0.receiveAttack(player1.attack(playerAttack));
////                    }
////                    if (player0.getHp() <= 0) {
////                        playerIsDefeated = true;
////                        System.out.println("player0 is defeated");
////                    }
////                }
////            }
////        }
////        System.out.println("player0 hp: " + player0.getHp());
////        System.out.println("player1 hp: " + player1.getHp());
////    }
//    public int attackDefend() throws SQLException {
//        FighterList list = new FighterList();
//        list.createMatchList();
//        Fighter player0 = list.getAFighter(0);
//        Fighter player1 = list.getAFighter(1);
//
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
//                System.out.println("player0 is defeated");
//            } else {
//                if (player1.getHp() <= 0) {
//                    playerwins = 0;
//                    playerIsDefeated = true;
//                    System.out.println("player1 is defeated");
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
//                        System.out.println("player0 is defeated");
//                    }
//                }
//            }
//        }
//        //System.out.println("player0 hp: " + player0.getHp());
//        //System.out.println("player1 hp: " + player1.getHp());
//        return playerwins;
//    }
//}
