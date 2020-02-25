package org.program.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.program.fighter.Fighter;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class SQLDatabaseTest {

    @BeforeEach
    void setUp() {
        SQLStatements stmt = new SQLStatements();
        String getFightersStatement = stmt.selectFighters();
        String getDefenseStatement = stmt.selectDefenceStrategies();
        String getAttacksStatement = stmt.selectAttacks();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getConnection() {
    }

    @Test
    void getInstance() throws SQLException {
        SQLDatabase db;
        assertNotNull(db = SQLDatabase.getInstance());
    }

    @Test
    void closeConnection() throws SQLException {

    }

    @Test
    //Check that fighters are returned when calling database.
    void getFighters() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        assertNotNull(db.getFighters());
    }

    @Test
    void resetHp() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        assertEquals(100, db.resetHp("Anna Williams"));
    }

    @Test
    void updateWins() {
    }
}