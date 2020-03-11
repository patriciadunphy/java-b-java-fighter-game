package org.program.tournament.fighter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FighterListTest {
static FighterList list = new FighterList();
    @BeforeAll
    static void setUp() throws SQLException {
        list.createTournamentList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFighters() {
        assertNotNull(list.getFighters());
    }

    @Test
    void removeFighter() {
        boolean pass;
        try {
            list.removeFighter(0);
            pass = true;
        } catch(Exception e){
            pass = false;
        }
        assertTrue(pass);
    }

    @Test
    void getSize() {
        assertEquals(16, list.getSize());
    }

    @Test
    void getFighter() {
        assertNotNull(list.getFighter(0));
    }

}