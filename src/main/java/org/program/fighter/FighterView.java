package org.program.fighter;

import org.program.ui.Sleep;

public class FighterView {
    public void printFighterAttack(String name, String chosenAttack){
        System.out.println(name + " attacks with a " + chosenAttack);
        //Sleep.pause(500);
    }
    public void printReceivedAttack(String name, int hp){
        System.out.println(name + " got hit, current HP: " + hp);
        //Sleep.pause(500);
    }
    public void printDefence(String name, String chosenDefence){
        System.out.println(name + " choose to defend with a " + chosenDefence + ". HP stays unchanged.");
        //Sleep.pause(500);
    }
}
