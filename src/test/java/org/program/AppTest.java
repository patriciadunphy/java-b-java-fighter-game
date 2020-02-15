package org.program;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;
import org.program.fighter.Fighter;
import org.program.fighter.FighterList;
import org.program.tournament.Tournament;

import java.sql.SQLException;

public class AppTest {
    //@Test
    public void getFightersInclAttacksAndDefenceTest() throws SQLException {
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
    public void resetHpTest() throws SQLException {
        FighterList firstList = new FighterList();
        firstList.createMatchList();
        Fighter a = new Fighter();
        a = firstList.getAFighter(0);
        a.setHp(70);
        System.out.println("Hp ska vara 70: "+a.getHp());
        a.resetHp();
        System.out.println("Hp ska vara återställt: "+a.getHp());
    }

    @Test
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
