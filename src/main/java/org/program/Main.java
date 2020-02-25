package org.program;


import org.program.tournament.Tournament;
import org.program.ui.UI;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UI ui = new UI();
        ui.run();
    }
}
