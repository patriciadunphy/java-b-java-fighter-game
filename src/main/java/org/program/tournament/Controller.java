package org.program.tournament;

import org.program.fighter.Fighter;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Controller {
    private List<Fighter> model;
    private View view;

    public Controller(List<Fighter> model, View view) {
        this.model = model;
        this.view = view;
    }
    public int getSize(){
        return model.size();
    }
    public List<Fighter> getFighterList(){
        return this.model;
    }
    public Fighter getAFighter(int i){
        return model.get(i);
    }
    //Testar denna metod
//    public void swapPlacesOnTwoFighters(){
//        Collections.swap(this.model, 0, 1);
//    }
    public String getFighterName(int i){
        return getAFighter(i).getName();
    }
    public int getHp(int i) {
        return getAFighter(i).getHp();
    }
    public void defend(int i, int chosenDefence){
        String defence = getAFighter(i).defend(chosenDefence);
        view.printDefence(getFighterName(i), defence);
    }
    public int attack(int i, int chosenAttack){
        view.printFighterAttack(getAFighter(i).getName(), getAFighter(i).getAttacks().get(chosenAttack).getStrategyDescription());
        return getAFighter(i).attack(chosenAttack);
    }
    public void receiveAttack(int i, int damage){
        getAFighter(i).receiveAttack(damage);
        view.printReceivedAttack(getFighterName(i), getHp(i));
    }
    public void resetHp(int i) throws SQLException {
        getAFighter(i).resetHp();
    }
    public void printDefeat(int i){
        view.printDefeat(getFighterName(i));
    }
    public void updateWins(int i) throws SQLException {
        model.get(i).updateWins();
    }
    public void printMatchList() {
        //Sätta en observer varje gång updateMatch-list
        // anropas för att sedan köra denna metod
        if (model.size() % 8 == 0) {
            view.printQuarterFinal();
        } else if (model.size() % 4 == 0) {
            view.printSemiFinal();
        } else if (model.size() % 2 == 0) {
            view.printFinal();
        }
        view.printMatchList(model);
    }
    public void printWinnerOfMatch(int i){
        view.printWinnerOfMatch(getFighterName(i), getAFighter(i).getQuote());
    }
    public void updateMatchList(List<Fighter> model) {
        this.model = model;
    }

    public void printWinner() {
        view.printWinner(getFighterList());
    }

    public void printNextMatch() {
        view.printNextMatch(getFighterList());
    }
}
