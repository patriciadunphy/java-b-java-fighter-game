package org.program.tournament;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.fighter.Fighter;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TournamentListTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTournamentList() throws SQLException {
        TournamentList list = new TournamentList();
        assertNotNull(list.getTournamentList());
    }

    @Test
    void checkTournamentListDefend() throws SQLException {
        TournamentList list = new TournamentList();
        List<Fighter> fighters = list.getTournamentList();
        int i = 1;
        for (Fighter fighter : fighters){
            System.out.println(fighter.getName());
            System.out.println(i++);
            System.out.println(fighter.getDefences());
        }
    }

    @Test
    void checkTournamentListAttack() throws SQLException {
        TournamentList list = new TournamentList();
        List<Fighter> fighters = list.getTournamentList();
        int i = 1;
        for (Fighter fighter : fighters) {
            System.out.println(fighter.getName());
            System.out.println(i++);
            System.out.println(fighter.getAttacks());
        }
    }

    @Test
    void checkTournamentListAttackAssert() throws SQLException {
        TournamentList list = new TournamentList();
        List<Fighter> fighters = list.getTournamentList();
        int i = 1;
        for (Fighter fighter : fighters) {
            System.out.println(fighter.getName());
            System.out.println(i++);
            System.out.println(fighter.getAttacks());
            System.out.println("SIZE: " +fighter.getAttacks().size());
        }

    }
}