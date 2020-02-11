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
    //Fetching fighters from the database, creating a new instance of Fighter for each fighter,
    // and putting them in a list of fighters
    public List<Fighter> getFighters(String getFightersStatement) throws SQLException {
        List<Fighter> fightersDb = new ArrayList<Fighter>();
        PreparedStatement getFightersStmt;
        ResultSet myRs;
        getFightersStmt = getConnection().prepareStatement(getFightersStatement);
        myRs = getFightersStmt.executeQuery();

        while (myRs.next()) {
            String name = myRs.getString("name");
            String quote = myRs.getString("quote");
            int hp = myRs.getInt("hp");
            int power = myRs.getInt("power");
            int speed = myRs.getInt("speed");
            int strength = myRs.getInt("strength");

            Fighter f = new Fighter()
                    .setName(name)
                    .setQuote(quote)
                    .setHp(hp)
                    .setPower(power)
                    .setSpeed(speed)
                    .setStrength(strength);
            fightersDb.add(f);
        }
        return fightersDb;
    }

    //Takes a list of fighter as attribute. Fetching defence for each fighter
    // from the database and updates the list of fighters
    public List<Fighter> addDefense(String getDefenseStatement, List<Fighter> fighters) throws SQLException {
        PreparedStatement getDefenseStmt;
        ResultSet myRs;
        getDefenseStmt = getConnection().prepareStatement(getDefenseStatement);
        myRs = getDefenseStmt.executeQuery();
        while (myRs.next()) {
            String strategyDescription = myRs.getString("strategy_description");
            String name = myRs.getString("name");
            for (Fighter f : fighters) {
                if (f.getName().equalsIgnoreCase(name)) {
                    f.addDefences(strategyDescription);
                    fighters.set(fighters.indexOf(f), f);
                }
            }
        }
        return fighters;
    }
    //Takes a list of fighter as attribute. Fetching attacks for each fighter
    // from the database and updates the list of fighters
    public List<Fighter> addAttacks(String getAttacksStatement, List<Fighter> fighters) throws SQLException {
        PreparedStatement getAttacksStmt;
        ResultSet myRs;
        getAttacksStmt = getConnection().prepareStatement(getAttacksStatement);
        myRs = getAttacksStmt.executeQuery();
        while (myRs.next()) {
            String strategyDescription = myRs.getString("strategy_description");
            String name = myRs.getString("name");
            int damage = myRs.getInt("damage");
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
}

//    public void executeUpdate(String sqlStatement, String lastName, String firstName) throws SQLException {
//        PreparedStatement myStmt;
//
//        myStmt = getConnection().prepareStatement(sqlStatement);
//
//        myStmt.setString(1, lastName);
//        myStmt.setString(2, firstName);
//
//        myStmt.executeUpdate();
//    }
//
//    public void updateActor(String sqlStatement, String oldLastName, String oldFirstName, String newLastName, String newFirstName) throws SQLException {
//        PreparedStatement myStmt;
//
//        myStmt = getConnection().prepareStatement(sqlStatement);
//
//        myStmt.setString(1, newLastName);
//        myStmt.setString(2, newFirstName);
//        myStmt.setString(3, oldLastName);
//        myStmt.setString(4, oldFirstName);
//
//        myStmt.executeUpdate();
//
//    }
//
//    public void searchActorAndFilm(String sqlStatement, String lastName, String firstName) throws SQLException {
//        PreparedStatement myStmt;
//        ResultSet myRs;
//
//        myStmt = getConnection().prepareStatement(sqlStatement);
//
//        myStmt.setString(1, lastName + "%");
//        myStmt.setString(2, firstName + "%");
//
//        myRs = myStmt.executeQuery();
//
//        while (myRs.next()) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(myRs.getDate("release_year"));
//            System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + " - "
//                    + myRs.getString("title") + ", " + calendar.get(Calendar.YEAR));
//        }
//
//

