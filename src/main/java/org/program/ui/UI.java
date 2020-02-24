package org.program.ui;

import org.program.tournament.NewTournament;

import java.sql.SQLException;

public class UI {
    public void run() throws SQLException {
        InputHandler input = new InputHandler();
        NewTournament tour = new NewTournament();
        System.out.println("1: Start game\n0: Quit");
        while (true) {
            switch (input.getIntInput()) {
                case 1:
                    tour.runTournament();
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Something went wrong.");
                    System.exit(0);
                    break;
            }
        }
    }
}
