package org.program.tournament;

import org.program.fighter.Fighter;

import java.util.List;

public class View {
    public void printFighterAttack(String name, String chosenAttack) {
        System.out.println(name + " attacks with a " + chosenAttack);
//        Sleep.pause(100);
    }

    public void printReceivedAttack(String name, int hp) {
        System.out.println(name + " got hit, current HP: " + hp);
//        Sleep.pause(100);
    }

    public void printDefence(String name, String chosenDefence) {
        System.out.println(name + " choose to defend with a " + chosenDefence + ". HP stays unchanged.");
//        Sleep.pause(100);
    }
    public void printDefeat(String name){
        System.out.println(name + " is defeated");
//        Sleep.pause(100);
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
//        Sleep.pause(500);
    }
    public void printQuarterFinal() {
        System.out.println("----------------------------");
        System.out.println("---QUARTER FINAL---");
//        Sleep.pause(100);
    }

    public void printSemiFinal() {
        System.out.println("----------------------------");
        System.out.println("---SEMI FINAL---");
//        Sleep.pause(100);
    }

    public void printFinal() {
        System.out.println("----------------------------");
        System.out.println("---FINAL---");
//        Sleep.pause(100);
    }
    public void printWinnerOfMatch(String name, String quote){
        System.out.println("----------------------------");
        System.out.println("Winner: " + name + ": \"" + quote + "\"");
        System.out.println("----------------------------");
//        Sleep.pause(500);
    }

    public void printWinner(List<Fighter> fighters) {
        System.out.println("----------------------------");
        System.out.println("The winner of the tournament is: ");
        System.out.println(fighters.get(0).getName());
        System.out.println("----------------------------");
//        Sleep.pause(500);
    }

    public void printNextMatch(List<Fighter> fighters) {
        System.out.println("Coming up: " + fighters.get(0).getName() + " VS. " + fighters.get(1).getName());
//        Sleep.pause(500);
    }
    public void printStartFight(){
        System.out.println("1: Start fight\n0: Quit");
    }
    public void printStartRound(int i){
        System.out.println("Round: "+i);
//        Sleep.pause(500);
    }
    public void printRunMatchSetsMenu(int i){
        System.out.println("1: Start round " + i + "\n0: Quit");
//        Sleep.pause(500);
    }
    public void printErrorMessage(){
        System.out.println("Something went wrong");
    }
    public void printQuit(){
        System.out.println("Quitting");
    }
    public void printHighscore(List<String> highscore){
        System.out.println("----------------------------");
        System.out.println("----------HIGHSCORE---------");
        for (String line : highscore) {
            System.out.println(line);
        }
        System.out.println("----------------------------");
    }
}
