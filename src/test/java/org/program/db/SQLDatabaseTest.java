package org.program.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.program.tournament.fighter.Fighter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class SQLDatabaseTest {

    /**
     * Creating a static instance variable, is static since the setup method needs to be static
     */
    static SQLDatabase db;
    static List<Fighter> fighters;

    /**
     * Before each test the getInstance method is invoked
     * @throws SQLException
     */
    @BeforeAll
    static void setup() throws SQLException {
        db = SQLDatabase.getInstance();
        fighters = db.getFighters();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getConnection() {
        boolean con;
        try{
            db.getConnection();
            con = true;
        } catch(Exception e){
            con = false;
        }
        assertTrue(con);
    }

    @Test
    void getInstance() throws SQLException {
        assertNotNull(db);
    }

    @Test
    void closeConnection() throws SQLException {
        boolean con;
        try{
            SQLDatabase.closeConnection(db.getConnection());
            con = true;
        } catch (Exception e){
            con = false;
        }
        assertTrue(con);
    }

    @Test
    /**
     * Check that fighters are returned when calling database.
     */
    void getFighters() throws SQLException {
        assertNotNull(db.getFighters());
    }

    @Test
    void resetHp() throws SQLException {
        db = SQLDatabase.getInstance();
        assertEquals(100, db.resetHp("Anna Williams"));
    }

    @Test
    void updateWins() throws SQLException {
        db = SQLDatabase.getInstance();
        boolean update;
        try {
            fighters.get(0).updateWins();
            update = true;
        } catch (Exception e){
            update = false;
        }
        assertTrue(update);
    }
}