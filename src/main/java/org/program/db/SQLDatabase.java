package org.program.db;

import java.sql.*;
import java.util.Calendar;

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
//    }
}
