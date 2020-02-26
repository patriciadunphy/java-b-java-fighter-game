package org.program.ui;

import org.program.fighter.Fighter;
import org.program.tournament.Tournament;
import org.program.tournament.TournamentList;

import java.sql.SQLException;
import java.util.List;

public class UI {
    public void run() throws SQLException {
        InputHandler input = new InputHandler();
        Tournament tour = new Tournament();
        System.out.println("1: Start game\n2: Highscores\n0: Quit");
        while (true) {
            switch (input.getIntInput()) {
                case 1:
                    tour.runTournament();
                case 2:
                    //Här hämtas metod för att visa highscores
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
