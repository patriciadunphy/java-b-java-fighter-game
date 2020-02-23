package org.program.fighter;

public class FighterView {
    public void printFighterAttack(String name, String chosenAttack){
        System.out.println(name + " attacks with a " + chosenAttack);
    }
    public void printReceivedAttack(String name, int hp){
        System.out.println(name + " got hit, current HP: " + hp);
    }
    public void printDefence(String name, String chosenDefence){
        System.out.println(name + " choose to defend with a " + chosenDefence + ". HP stays unchanged.");
    }
}
