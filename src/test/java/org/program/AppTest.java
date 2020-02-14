package org.program;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;
import org.program.fighter.FighterList;
import org.program.tournament.Tournament;

import java.sql.SQLException;

public class AppTest {
    //    @Test
//    public void addFightersToListTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        db.getFighters(stmt.selectAllFighters());
//    }
//    // @Test
//    public void checkListOfFightersTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        FighterList a = new FighterList();
//        //---Fetching fighters from db and putting them in Tournament Fighters list---
//        a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
//        //---Adding attacks to player and updating tournament fighters list
//        db.addAttacks(stmt.getAllAttacks(), a.getFighters());
//        //---Adding defence to player and updating tournament fighters list
//        db.addDefense(stmt.selectDefenceStrategies(), a.getFighters());
//        a.printFightersList();
//
//        db.closeConnection(db.getConnection());
//    }
    @Test
    public void getFightersInclAttacksAndDefenceTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        FighterList fighters = new FighterList();
//        fighters.insertFightersFromDb(db.getFightersWithAttacksAndDefence(stmt.selectAllFighters(), stmt.selectDefenceStrategies(), stmt.getAllAttacks()));
//        fighters.printFightersList();
        FighterList a = new FighterList();
        a.createMatchList();
        a.printFightersList();
    }

    //@Test
    public void testTournamentFightersTest() throws SQLException {
        FighterList a = new FighterList();
        a.createMatchList();
        a.printFightersList();
    }
    //@Test
    public void matchTest() throws SQLException {
        FighterList firstList = new FighterList();
        FighterList secondList = new FighterList();
        FighterList finalList = new FighterList();
        Tournament match = new Tournament();
        firstList.createMatchList();
        while (firstList.getListSize() >= 2 || secondList.getListSize() >= 2) {
            //Startar första delen av turneringen
            secondList = match.startTournament(firstList);
            //Startar andra delen av turneringen genom att
            //ta listan med de som gått vidare köra startTournament-metoden igen
            if (secondList.getListSize()>=2){
                firstList = match.startTournament(secondList);
            }
        }
        if (secondList.getListSize() == 0) {
            System.out.println("The winner is: ");
            System.out.println(firstList.getAFighter(0).getName());
        } else {
            System.out.println("The winner is: ");
            System.out.println(secondList.getAFighter(0).getName());
        }
        //Kontrollerar att ena listan är tom och den andra innehåller vinnaren
        //System.out.println(secondList.getListSize());
        //System.out.println(firstList.getListSize());

    }

    //@Test
    public void returnZeroOneOrTwoTest() {
        System.out.println((int) (Math.random() * (-1 - 2)) + 2);

    }

}
