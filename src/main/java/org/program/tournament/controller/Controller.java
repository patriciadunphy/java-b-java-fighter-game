package org.program.tournament.controller;

import org.program.db.SQLDatabase;
import org.program.tournament.view.View;
import org.program.tournament.fighter.Fighter;
import org.program.tournament.fighter.FighterList;
import org.program.ui.Sleep;

import java.sql.SQLException;
import java.util.List;

/**
 * Controller for tournament
 */
public class Controller {
    /**
     * Controller constructor
     */
    private FighterList model;
    private View view;

    public Controller(FighterList model, View view) {
        this.model = model;
        this.view = view;
    }

    public int getSize() {
        return model.getSize();
    }

    public FighterList getFighterList() {
        return this.model;
    }

    public Fighter getAFighter(int i) {
        return model.getFighter(i);
    }

    public String getFighterName(int i) {
        return getAFighter(i).getName();
    }

    public int getHp(int i) {
        return getAFighter(i).getHp();
    }

    public void printStartScreen() {
        view.printStartScreen();
    }

    /**
     * Fighter on index i will defend with the chosen defence method
     * The fighter's name and defence method will be printed
     *
     * @param i
     * @param chosenDefence
     */
    public void defend(int i, int chosenDefence) {
        String defence = getAFighter(i).defend(chosenDefence);
        view.printDefence(getFighterName(i), defence);
        Sleep.pause(100);
    }

    /**
     * Fighter on index i will attack with the chosen attack method
     * The fighter's name and defence method will be printed
     *
     * @param i
     * @param chosenAttack
     * @return
     */
    public int attack(int i, int chosenAttack) {
        view.printFighterAttack(getAFighter(i).getName(), getAFighter(i).getAttacks().get(chosenAttack).getStrategyDescription());
        Sleep.pause(100);
        return getAFighter(i).attack(chosenAttack);
    }

    /**
     * Fighter on index i will receive an attack which will affect the fighter's hp
     * The fighter's name and hp after received attack will be printed
     *
     * @param i
     * @param damage
     */
    public void receiveAttack(int i, int damage) {
        getAFighter(i).receiveAttack(damage);
        view.printReceivedAttack(getFighterName(i), getHp(i));
        Sleep.pause(100);
    }

    public void resetHp(int i) throws SQLException {
        getAFighter(i).resetHp();
    }

    public void printDefeat(int i) {
        view.printDefeat(getFighterName(i));
        Sleep.pause(200);
    }

    public void updateWins(int i) throws SQLException {
        model.getFighter(i).updateWins();
    }

    public void printMatchList() {
        //TO DO: Sätta en observer varje gång updateMatch-list
        // anropas för att sedan köra denna metod
        if (model.getSize() % 8 == 0) {
            view.printQuarterFinal();
        } else if (model.getSize() % 4 == 0) {
            view.printSemiFinal();
        } else if (model.getSize() % 2 == 0) {
            view.printFinal();
        }
        view.printMatchList(model.getFighters());
        Sleep.pause(200);
    }

    public void printWinnerOfMatch(int i) {
        view.printWinnerOfMatch(getFighterName(i), getAFighter(i).getQuote());
        Sleep.pause(200);
    }

    public void updateMatchList(FighterList model) {
        this.model = model;
    }

    public void printWinner() {
        view.printWinner(getFighterList().getFighters());
        Sleep.pause(200);
    }

    public void printNextMatch() {
        view.printNextMatch(getFighterList().getFighters());
        Sleep.pause(200);
    }

    public void printStartRound(int i) {
        view.printStartRound(i);
    }

    public void printRunMatchSetsMenu(int i) {
        view.printRunMatchSetsMenu(i);
        Sleep.pause(200);
    }

    public void printErrorMessage() {
        view.printErrorMessage();
        Sleep.pause(200);
    }

    public void printQuit() {
        view.printQuit();
    }

    public void printStartFight() {
        view.printStartFight();
        Sleep.pause(200);
    }

    public void printHighscore() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        /**
         * Fetching highscore list from database and inserting results to a list
         */
        List<String> highscore = db.getWins();
        view.printHighscore(highscore);
        Sleep.pause(200);
    }
}
