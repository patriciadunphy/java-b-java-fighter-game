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
    //Structure for matches
    public void gameStart(TournamentFighters tour) {
        int listSize = tour.getListSize();
        while (listSize != 0) {
            int r = (int) (Math.random() * (tour.getListSize()));
            System.out.println(tour.getAFighter(r));
            tour.removeFromTournament(tour.getAFighter(r));
            listSize -= 1;
        }
    }
}
