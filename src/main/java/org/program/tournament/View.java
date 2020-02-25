package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.ui.Sleep;

import java.util.List;

public class View {
    public void printFighterAttack(String name, String chosenAttack) {
        System.out.println(name + " attacks with a " + chosenAttack);
        //Sleep.pause(500);
    }

    public void printReceivedAttack(String name, int hp) {
        System.out.println(name + " got hit, current HP: " + hp);
        //Sleep.pause(500);
    }

    public void printDefence(String name, String chosenDefence) {
        System.out.println(name + " choose to defend with a " + chosenDefence + ". HP stays unchanged.");
        //Sleep.pause(500);
    }
    public void printDefeat(String name){
        System.out.println(name + " is defeated");
    }

    public void printMatchList(List<Fighter> fighters) {
        int i = 1;
        System.out.println("----------------------------");
        System.out.println("UPCOMING MATCHES");
        for (Fighter fighter : fighters) {
            if (i % 2 != 0)
                System.out.print(fighter.getName() + " VS. ");
            else {
                System.out.println(fighter.getName());
            }
            i += 1;
        }
        System.out.println("----------------------------");
        Sleep.pause(500);
    }

    public void printQuarterFinal() {
        System.out.println("---QUARTER FINAL---");
    }

    public void printSemiFinal() {
        System.out.println("---SEMI FINAL---");
    }

    public void printFinal() {
        System.out.println("---FINAL---");
    }
    public void printWinnerOfMatch(String name, String quote){
        System.out.println("Winner: " + name + ": \"" + quote + "\"");
    }

    public void printWinner(List<Fighter> fighters) {
        System.out.println("----------------------------");
        System.out.println("The winner of the tournament is: ");
        System.out.println(fighters.get(0).getName());
        System.out.println("----------------------------");
    }

    public void printNextMatch(List<Fighter> fighters) {
        System.out.println("Coming up: " + fighters.get(0).getName() + " VS. " + fighters.get(1).getName());
        Sleep.pause(500);
    }
}