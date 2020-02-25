package org.program.db;

import org.program.fighter.Attack;
import org.program.fighter.Fighter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLDatabase {
    private static SQLDatabase instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/fighterapp";
    private String user = "student";
    private String pass = "123";

    //Singleton for database-connection
    private SQLDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static SQLDatabase getInstance() throws SQLException {
        if (instance == null) {
            instance = new SQLDatabase();
        } else if (instance.getConnection().isClosed()) {
            instance = new SQLDatabase();
        }
        return instance;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    public List<Fighter> getFighters() throws SQLException {
        SQLStatements stmt = new SQLStatements();
        String getFightersStatement = stmt.selectFighters();
        String getDefenseStatement = stmt.selectDefenceStrategies();
        String getAttacksStatement = stmt.selectAttacks();

        List<Fighter> fighters = new ArrayList<Fighter>();
        PreparedStatement getFightersStmt;
        ResultSet myRsFighters;
        getFightersStmt = getConnection().prepareStatement(getFightersStatement);
        myRsFighters = getFightersStmt.executeQuery();

        while (myRsFighters.next()) {
            String name = myRsFighters.getString("name");
            String quote = myRsFighters.getString("quote");
            int hp = myRsFighters.getInt("hp");
            int power = myRsFighters.getInt("power");
            int speed = myRsFighters.getInt("speed");
            int strength = myRsFighters.getInt("strength");
            int wins = myRsFighters.getInt("wins");

            Fighter f = new Fighter()
                    .setName(name)
                    .setQuote(quote)
                    .setHp(hp)
                    .setPower(power)
                    .setSpeed(speed)
                    .setStrength(strength)
                    .setWins(wins);

            fighters.add(f);
        }
        PreparedStatement getDefenseStmt;
        ResultSet myRsDefence;
        getDefenseStmt = getConnection().prepareStatement(getDefenseStatement);
        myRsDefence = getDefenseStmt.executeQuery();
        while (myRsDefence.next()) {
            String strategyDescription = myRsDefence.getString("strategy_description");
            String name = myRsDefence.getString("name");
            for (Fighter f : fighters) {
                if (f.getName().equalsIgnoreCase(name)) {
                    f.addDefences(strategyDescription);
                    fighters.set(fighters.indexOf(f), f);
                }
            }
        }
        PreparedStatement getAttacksStmt;
        ResultSet myRsAttacks;
        getAttacksStmt = getConnection().prepareStatement(getAttacksStatement);
        myRsAttacks = getAttacksStmt.executeQuery();
        while (myRsAttacks.next()) {
            String strategyDescription = myRsAttacks.getString("strategy_description");
            String name = myRsAttacks.getString("name");
            int damage = myRsAttacks.getInt("damage");
            for (Fighter f : fighters) {
                if (f.getName().equalsIgnoreCase(name)) {
                    Attack attack = new Attack()
                            .setDamage(damage)
                            .setStrategyDescription(strategyDescription);
                    f.addAttacks(attack);
                    fighters.set(fighters.indexOf(f), f);
                }
            }
        }
        closeConnection(getConnection());
        return fighters;
    }

    public int resetHp(String fighterName) throws SQLException {
        SQLStatements stmt = new SQLStatements();
        String getHpStatement = stmt.selectHp();

        PreparedStatement getFightersStmt;
        ResultSet myRsHp;
        getFightersStmt = getConnection().prepareStatement(getHpStatement);
        getFightersStmt.setString(1, fighterName);
        myRsHp = getFightersStmt.executeQuery();
        int hp = 0;
        while (myRsHp.next()) {
            hp = myRsHp.getInt("hp");
        }
        return hp;
    }

    public void updateWins(String fighterName, int wins) throws SQLException {
        SQLStatements stmt = new SQLStatements();
        String updateStatement = stmt.updateWins();

        PreparedStatement updateWinsStatement;
        updateWinsStatement = getConnection().prepareStatement(updateStatement);
        updateWinsStatement.setInt(1, wins);
        updateWinsStatement.setString(2, fighterName);
        updateWinsStatement.executeUpdate();
    }
}

