package org.program.tournament;

import org.program.fighter.Fighter;
import org.program.fighter.FighterList;

import java.util.List;

public class TournamentController {
    private List<Fighter> model;
    private TournamentView view;

    public TournamentController(List<Fighter> model, TournamentView view){
        this.model = model;
        this.view = view;
    }
    public void printMatchList(){
        view.printMatchList(this.model);
    }
}
