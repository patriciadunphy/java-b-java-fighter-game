package org.program;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;
import org.program.fighter.Fighter;
import org.program.fighter.TournamentFighters;
import org.program.match.Match;

import java.sql.SQLException;

public class AppTest{
//    @Test
//    public void addFightersToListTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        db.getFighters(stmt.selectAllFighters());
//    }
   // @Test
    public void checkListOfFightersTest() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        SQLStatements stmt = new SQLStatements();
        TournamentFighters a = new TournamentFighters();
        //---Fetching fighters from db and putting them in Tournament Fighters list---
        a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
        //---Adding attacks to player and updating tournament fighters list
        db.addAttacks(stmt.getAllAttacks(), a.getFighters());
        //---Adding defence to player and updating tournament fighters list
        db.addDefense(stmt.selectDefenceStrategies(), a.getFighters());
        a.printFightersList();

        db.closeConnection(db.getConnection());
    }
    //@Test
    public void testTournamentFightersTest() throws SQLException {
        TournamentFighters a = new TournamentFighters();
        a.createMatchList();
        a.printFightersList();
    }
    @Test
    public void matchTest() throws SQLException {
        TournamentFighters a = new TournamentFighters();
        Match match = new Match();
        a.createMatchList();
        match.startGame2(a);
    }
    //@Test
    public void returnOneOrZeroTest(){
//        System.out.println((int) (Math.random() * (1-0))+0);
        System.out.println((int) (Math.random()*(1-10))+10);
    }

//    @Test
//    public void AttackAndDefendTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        TournamentFighters tournament = new TournamentFighters();
//        //Hämtar fighters från databasen
//        tournament.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
//        //Lägger till attacker i listan över fighters
//        db.addAttacks(stmt.getAllAttacks(), tournament.getFighters());
//        //Lägger till defend-metoder i listan över fighters
//        db.addDefense(stmt.selectDefenceStrategies(), tournament.getFighters());
//        Fighter player1 = tournament.getAFighter(2);
//        Fighter player2 = tournament.getAFighter(3);
//        int damage = player1.attack(1);
//        player2.defend(1,damage);
//
//    }
//    @Test
//    public void testAttackMethod() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        TournamentFighters tournament = new TournamentFighters();
//
//        tournament.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
//        db.addAttacks(stmt.getAllAttacks(), tournament.getFighters());
//        db.addDefense(stmt.selectDefenceStrategies(), tournament.getFighters());
//        tournament.getAFighter(1).attack((tournament.getAFighter(2)), 1);
//    }

//    @Test
//    public void fightTest() throws SQLException {
//        SQLDatabase db = SQLDatabase.getInstance();
//        SQLStatements stmt = new SQLStatements();
//        TournamentFighters a = new TournamentFighters();
//        a.insertFightersFromDb(db.getFighters(stmt.selectAllFighters()));
//        Fight fight = new Fight();
//        fight.executeFight(a.getAFighter(2), a.getAFighter(3));
//    }

//    public void testRandom() throws SQLException {
//        TournamentFighters a = new TournamentFighters();
//        Match match = new Match();
//        a.createMatchList();
//        match.gameStart(a.getFighters());
//    }
    //@Test

}
