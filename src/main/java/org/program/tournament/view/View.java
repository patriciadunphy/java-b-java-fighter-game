package org.program.tournament.view;

import org.program.tournament.fighter.Fighter;

import java.util.List;

public class View {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void printFighterAttack(String name, String chosenAttack) {
        System.out.println(name + " attacks with a " + chosenAttack);
    }

    public void printReceivedAttack(String name, int hp) {
        System.out.println(name + " got hit, current HP: " + hp);
    }

    public void printDefence(String name, String chosenDefence) {
        System.out.println(name + " choose to defend with a " + chosenDefence + ". HP stays unchanged.");
    }
    public void printDefeat(String name){
        System.out.println(name + " is defeated");
    }

    public void printStartScreen(){
        System.out.println(ANSI_RED+"   ___                   ______ _       _     _            \n" +
                "  |_  |                  |  ___(_)     | |   | |           \n" +
                "    | | __ ___   ____ _  | |_   _  __ _| |__ | |_ ___ _ __ \n" +
                "    | |/ _` \\ \\ / / _` | |  _| | |/ _` | '_ \\| __/ _ \\ '__|\n" +
                "/\\__/ / (_| |\\ V / (_| | | |   | | (_| | | | | ||  __/ |   \n" +
                "\\____/ \\__,_| \\_/ \\__,_| \\_|   |_|\\__, |_| |_|\\__\\___|_|   \n" +
                "                                   __/ |                   \n" +
                "                                  |___/                    "+ ANSI_RESET);
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
    }
    public void printQuarterFinal() {
        System.out.println("----------------------------");
        System.out.println("---QUARTER FINAL---");
    }

    public void printSemiFinal() {
        System.out.println("----------------------------");
        System.out.println("---SEMI FINAL---");
    }

    public void printFinal() {
        System.out.println("----------------------------");
        System.out.println("---FINAL---");
    }
    public void printWinnerOfMatch(String name, String quote){
        System.out.println(ANSI_CYAN+"----------------------------");
        System.out.println("Winner: " + name + ": \"" + quote + "\"");
        System.out.println("----------------------------"+ ANSI_RESET);
    }

    public void printWinner(List<Fighter> fighters) {
        System.out.println(ANSI_BLUE+"----------------------------");
        System.out.println("The winner of the tournament is: ");
        System.out.println(ANSI_GREEN+fighters.get(0).getName());
        System.out.println(ANSI_BLUE+"----------------------------"+ ANSI_RESET);
    }

    public void printNextMatch(List<Fighter> fighters) {
        System.out.println("Coming up: " + fighters.get(0).getName() + " VS. " + fighters.get(1).getName());
    }
    public void printStartFight(){
        System.out.println("1: Start fight\n0: Quit");
    }
    public void printStartRound(int i){
        System.out.println("Round: "+i);
    }
    public void printRunMatchSetsMenu(int i){
        System.out.println("1: Start round " + i + "\n0: Quit");
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
