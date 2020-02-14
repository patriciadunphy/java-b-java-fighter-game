package org.program.fighter;

import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FighterList {
    private List<Fighter> fighters = new ArrayList<Fighter>();

    public int getListSize() {

        return fighters.size();
    }

    public void shuffleList() {
        Collections.shuffle(this.fighters);
        //this.fighters.
    }

    public void addToTournament(Fighter fighter) {

        this.fighters.add(fighter);
    }

    public void removeFromTournament(Fighter fighter) {

        this.fighters.remove(fighter);
    }

    public List<Fighter> getFighters() {

        return fighters;
    }

    public Fighter getAFighter(int i) {

        return fighters.get(i);
    }

    public void insertFightersFromDb(List<Fighter> fighters) {

        this.fighters.addAll(fighters);
    }

    public void updateFighterInList(int i, Fighter fighter) {
        this.fighters.set(i, fighter);
    }

    public void printFightersList() {
        for (Fighter fighter : this.fighters) {
            System.out.println(fighter);
        }
    }

    //    public void createMatchList() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        FighterList a = new FighterList();
//        //---Fetching fighters from db and putting them in Tournament Fighters list---
//        a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
//        //---Adding attacks to player and updating tournament fighters list
//        db.addAttacks(stmt.getAllAttacks(), a.getFighters());
//        //---Adding defence to player and updating tournament fighters list
//        db.addDefense(stmt.selectDefenceStrategies(), a.getFighters());
//        //a.printFightersList();
//        this.fighters.addAll(a.getFighters());
//        db.closeConnection(db.getConnection());
//        //Shuffles the fighters in the list
//        Collections.shuffle(this.fighters);
    public void createMatchList() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        SQLStatements stmt = new SQLStatements();
        FighterList a = new FighterList();
        //---Fetching fighters from db and putting them in Tournament Fighters list---
        a.insertFightersFromDb(db.getFightersWithAttacksAndDefence(stmt.selectAllFighters(), stmt.selectDefenceStrategies(), stmt.getAllAttacks()));
        this.fighters.addAll(a.getFighters());
        db.closeConnection(db.getConnection());
        //Shuffles the fighters in the list
        Collections.shuffle(this.fighters);

    }
    //Create observer and observe when a fighter is removed from tournament due to losing?
}
