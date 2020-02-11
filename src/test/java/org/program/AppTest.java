package org.program;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;
import org.program.fighter.Fighter;
import org.program.fighter.TournamentFighters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppTest{
//    @Test
//    public void addFightersToListTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        db.getFighters(stmt.selectAllFighters());
//    }
    @Test
    public void checkListOfFightersTest() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        SQLStatements stmt = new SQLStatements();
        TournamentFighters a = new TournamentFighters();
        //---Fetching fighters from db and putting them in Tournament Fighters list---
        //a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
        //---Print all fighters in list---
        //a.printFightersList();
    }
}
