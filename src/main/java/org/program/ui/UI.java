package org.program.ui;

import org.program.tournament.Tournament;
import org.program.tournament.view.View;
import org.program.tournament.controller.Controller;

import java.sql.SQLException;

public class UI {
    public void run() throws SQLException {
        InputHandler input = new InputHandler();
        Tournament tour = new Tournament();
        View view = new View();
        /**
         * FighterList is not used in this method thus it is set to null
         */
        Controller controller = new Controller(null, view);
        controller.printStartScreen();
        while (true) {
            System.out.println("1: Start game\n2: Highscores\n0: Quit");
            switch (input.getIntInput()) {
                case 1:
                    tour.runTournament();
                    break;
                case 2:
                    controller.printHighscore();
                    break;
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
