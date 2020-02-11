package org.program.db;

import org.program.fighter.Attack;
import org.program.fighter.Fighter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDatabase {
    private static SQLDatabase instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/fighterapp";
    private String user = "student";
    private String pass = "123";

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

    public List<Fighter> getFighters(String getFightersStatement, String getAttacksStatement) throws SQLException {
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
        PreparedStatement getAttacksStmt;
        ResultSet myRs2;
        getAttacksStmt = getConnection().prepareStatement(getAttacksStatement);
        myRs2 = getAttacksStmt.executeQuery();
        while (myRs2.next()){
            String strategyDescription = myRs2.getString("strategy_description");
            String name = myRs2.getString("name");
            int damage = myRs2.getInt("damage");
            for (Fighter f : fightersDb){
                if (f.getName() == name){
                    Attack attack = new Attack()
                            .setDamage(damage)
                            .setStrategyDescription(strategyDescription);
                    f.addAttacks(attack);
                }
            }
        }
    return fightersDb;


//    public List<Fighter> getFighters(String sqlStatement) throws SQLException {
//        List<Fighter> fightersDb = new ArrayList<Fighter>();
//        PreparedStatement myStmt;
//        ResultSet myRs;
//        myStmt = getConnection().prepareStatement(sqlStatement);
//
//        myRs = myStmt.executeQuery();
//
//        while (myRs.next()) {
//            String name = myRs.getString("name");
//            String quote = myRs.getString("quote");
//            int hp = myRs.getInt("hp");
//            int power = myRs.getInt("power");
//            int speed = myRs.getInt("speed");
//            int strength = myRs.getInt("strength");
//
//            Fighter f = new Fighter()
//                    .setName(name)
//                    .setQuote(quote)
//                    .setHp(hp)
//                    .setPower(power)
//                    .setSpeed(speed)
//                    .setStrength(strength);
//            fightersDb.add(f);
//        }
//        return fightersDb;

//    public void searchActor(String sqlStatement, String lastName, String firstName) throws SQLException {
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
//            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
//        }
//    }
//
//
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
    }
}
