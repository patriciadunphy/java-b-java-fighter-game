package org.program.tournament;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.tournament.fighter.Fighter;
import org.program.tournament.fighter.FighterList;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    static FighterList fighters = new FighterList();
    static Tournament tour = new Tournament();
    static final List<Integer> VALID_VALUES = Arrays.asList(0, 1);

    @BeforeAll
    static void setUp() throws SQLException {
        fighters.createTournamentList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createNewTournament() throws SQLException {

    }

    /**
     * Test to check that the value returned is either 0 or 1
     *
     * @throws SQLException
     */
    @Test
    void runMatch() throws SQLException {
        FighterList twoFighters = new FighterList();
        twoFighters.addFighter(fighters.getFighter(0));
        twoFighters.addFighter(fighters.getFighter(1));

        assertTrue(VALID_VALUES.contains(tour.runMatch(twoFighters)));
    }

    @Test
    void attack() {
        boolean pass;
        try {
            tour.attack(fighters.getFighter(0), fighters.getFighter(1));
            pass = true;
        } catch (Exception e) {
            pass = false;
        }
        assertTrue(pass);
    }

    /**
     * Test to confirm that HP of attacker stays unchanged
     */
    @Test
    void attackCheckHpOfAttacker() {
        tour.attack(fighters.getFighter(0), fighters.getFighter(1));
        assertEquals(100, fighters.getFighter(0).getHp());
    }

    /**
     * Test to confirm that hp is decreasing after an attack
     */
    @Test
    void attackCheckHpOfDefender() {
        tour.attack(fighters.getFighter(0), fighters.getFighter(1));
        assertTrue(fighters.getFighter(1).getHp()<100);
    }
}