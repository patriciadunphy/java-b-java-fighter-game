package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.fighter.FighterList;

import java.sql.SQLException;

public class TournamentAttackTest {
    //Attack and random works
    public void attackDefend() throws SQLException {
        FighterList list = new FighterList();
        list.createMatchList();
        Fighter player0 = list.getAFighter(0);
        Fighter player1 = list.getAFighter(1);
        int playerDefence = (int) (Math.random() * (-1 - 2)) + 2;

        player0.getHp();
        player1.getHp();

        boolean playerIsDefeated = false;
        int playerAttack;
        while (!playerIsDefeated) {
            playerAttack = (int) (Math.random() * (-1 - 2)) + 2;
            //System.out.println("printing random: "+playerAttack);

            player1.receiveAttack(player0.attack(playerAttack));
            if (player0.getHp() <=0) {
                playerIsDefeated = true;
                System.out.println("player0 is defeated");
            } else {
                if (player1.getHp() <=0) {
                    playerIsDefeated = true;
                    System.out.println("player1 is defeated");
                } else {
                    player0.receiveAttack(player1.attack(playerAttack));
                    if (player0.getHp()<=0){
                        playerIsDefeated = true;
                        System.out.println("player0 is defeated");
                    }
                }

            }
        }

        //player1.receiveAttack(player0.attack(playerAttack));

        //player1.attack(playerAttack);
        //player0.defend(playerDefence);
        System.out.println("player0 hp: " + player0.getHp());
        System.out.println("player1 hp: " + player1.getHp());
        //player1.setHp(player1.getHp()-player0.attack(playerAttack));

//        System.out.println("Skriver ut player0 attack: "+player0.attack(playerAttack));
//        System.out.println("Skriver ut player1 hp efter attack "+player1.getHp());
//        System.out.println("Skriver ut player0 efter attack, ska vara oförändrat: "+player0.getHp());

    }
}
