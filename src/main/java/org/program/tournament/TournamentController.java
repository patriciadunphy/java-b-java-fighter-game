package org.program.tournament;

import org.program.fighter.Fighter;

import java.util.List;

public class TournamentController {
    private List<Fighter> model;
    private TournamentView view;

    public TournamentController(List<Fighter> model, TournamentView view) {
        this.model = model;
        this.view = view;
    }

    public List<Fighter> getFighterList() {
        return model;
    }

    //    public void printMatchList(){
//        view.printMatchList(getFighterList());
//        //Sätta en observer varje gång updateMatch-list
//        // anropas för att sedan köra denna metod
//    }
    public void printMatchList() {
        //Sätta en observer varje gång updateMatch-list
        // anropas för att sedan köra denna metod
        if (getFighterList().size() % 8 == 0) {
            view.printQuarterFinal();
        } else if (getFighterList().size() % 4 == 0) {
            view.printSemiFinal();
        } else if (getFighterList().size() % 2 == 0) {
            view.printFinal();
        }
        view.printMatchList(getFighterList());


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
