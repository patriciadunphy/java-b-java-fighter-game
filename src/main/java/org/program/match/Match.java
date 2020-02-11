package org.program.match;

import org.program.fighter.Fighter;
import org.program.fighter.TournamentFighters;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Match {
    /*
    public void
    Du måste också skapa en matchklass, det här är
    klassen som är ansvarig för att skapa en match
    mellan två Fighter's i turneringen.
     */
    /*
     *Rapportera via terminalen det kommande slaget, fighter name vs fighter name till exempel
     *Ett kommandoradsinterface för att starta en kamp och varje runda.
     *Tre slagrunder och rekord vilken fighter som vann varje omgång.
     *Bäst av tre omgångar logik för att bestämma vinnaren.
     *Uppdatera turneringen med den vinnande kämpen.
     *Skriv i terminalen mottoet för den vinnande fighter.

     */
    public void gameStart(List<Fighter> tour) throws SQLException {
        int r = (int) (Math.random() * (tour.size()))+1;
        System.out.println(r);
        System.out.println(tour.size());

    }
}
