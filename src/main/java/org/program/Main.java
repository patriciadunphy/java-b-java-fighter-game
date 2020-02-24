package org.program;


import org.program.fighter.Fighter;
import org.program.tournament.Controller;
import org.program.tournament.NewTournament;
import org.program.tournament.TournamentList;
import org.program.tournament.View;
import org.program.ui.UI;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        UI ui = new UI();
//        ui.run();
        NewTournament tour = new NewTournament();
        tour.runTournament();



    }
}
