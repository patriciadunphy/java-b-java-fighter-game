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

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
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


        //db.getFighters(stmt.selectAllFighters());
        TournamentFighters a = new TournamentFighters();
        a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));

        a.printFightersList();
    }
}
