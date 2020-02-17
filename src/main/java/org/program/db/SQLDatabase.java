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

    public List<Fighter> getFighters(String getFightersStatement, String getDefenseStatement, String getAttacksStatement) throws SQLException {
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

            Fighter f = new Fighter()
                    .setName(name)
                    .setQuote(quote)
                    .setHp(hp)
                    .setPower(power)
                    .setSpeed(speed)
                    .setStrength(strength);
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

        return fighters;
    }

    //    public Fighter resetHp(String getHpStatement, Fighter fighter) throws SQLException {
//        PreparedStatement getFightersStmt;
//        ResultSet myRsHp;
//        String fighterName = fighter.getName();
//        getFightersStmt = getConnection().prepareStatement(getHpStatement);
//        getFightersStmt.setString(1,fighterName);
//        myRsHp = getFightersStmt.executeQuery();
//        while (myRsHp.next()){
//            int hp = myRsHp.getInt("hp");
//            fighter.setHp(hp);
//        }
//        return fighter;
//    }
    public int resetHp(String getHpStatement, String fighterName) throws SQLException {
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
}

