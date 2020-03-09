package org.program.db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class SQLDatabaseTest {

    /**
     * Creating a static instance variable, is static since the setup method needs to be static
     */
    static SQLDatabase db;

    /**
     * Before each test the getInstance method is invoked
     * @throws SQLException
     */
    @BeforeAll
    static void setup() throws SQLException {
        db = SQLDatabase.getInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getConnection() {
        fail("This test has not yet been implemented");
    }

    @Test
    void getInstance() throws SQLException {
        assertNotNull(db);
    }

    @Test
    void closeConnection() throws SQLException {
        fail("This test has not yet been implemented");
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
        assertEquals(100, db.resetHp("Anna Williams"));
    }

    @Test
    void updateWins() {
        fail("This test has not yet been implemented");
    }
}