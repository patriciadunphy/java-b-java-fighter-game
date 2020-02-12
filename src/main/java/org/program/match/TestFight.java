//package org.program.match;
//
//import org.program.fighter.Attack;
//import org.program.fighter.Fighter;
//import org.program.ui.InputHandler;
//
//import java.util.List;
//
//public class Fight {
//    // i match class något randomiserat som skickar in en två fighters
//    InputHandler input = new InputHandler();
//    public Fighter executeFight(Fighter player1, Fighter player2){
//        Attack attack = new Attack();
//        int player1Wins = 0;
//        int player2Wins = 0;
//        List<Attack> attackP1 = player1.getAttacks();
//        List<Attack> attackP2 = player2.getAttacks();
//        List<String> defenceP1 = player1.getDefences();
//        List<String> defenceP2 = player2.getDefences();
//        //First round
//
//        while (true){
//        //int setDamage = 0;
//            System.out.println("Player 1 make a move, press 1, 2 or 3");
//            switch(input.getIntInput()){
//                case 1:
//                    //attackP1.get(1).getDamage();
//                    System.out.println(attackP1.get(1).getStrategyDescription());
//                    System.out.println("Player 2 choose a defence strategy, press 1, 2 or 3");
//                    //test
//                    player2.setHp(0);
//                    System.out.println("player2 dead");
//                    while(true){
//                        switch (input.getIntInput()) {
//                            case 1:
//                                System.out.println(defenceP2.get(1));
//                                break;
//                            case 2:
//                                System.out.println(defenceP2.get(2));
//                                break;
//                            case 3:
//                                System.out.println(defenceP2.get(3));
//                                break;
//                        }
//                    }
//
//                case 2:
//                    attackP1.get(2).getDamage();
//                    System.out.println(attackP1.get(2).getStrategyDescription());
//                    break;
//                case 3:
//                    attackP1.get(3).getDamage();
//                    System.out.println(attackP1.get(3).getStrategyDescription());
//                    break;
//                case 0: System.exit(0);
//                default:
//                    System.out.println("Felaktig inmatning");
//                break;
//
//
//
//            }
//
//        }
////        if (player1Wins > player2Wins) {
////            return player1;
////        } else
////            return player2;
//    }
//}
