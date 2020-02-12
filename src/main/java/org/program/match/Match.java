package org.program.match;

import org.program.fighter.Fighter;
import org.program.fighter.TournamentFighters;


import java.util.ArrayList;

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
//    public void gameStart(TournamentFighters tour) {
//        int listSize = tour.getListSize();
//        while (listSize != 0) {
//            int r = (int) (Math.random() * (tour.getListSize()));
//            System.out.println(tour.getAFighter(r));
//            tour.removeFromTournament(tour.getAFighter(r));
//            listSize -= 1;
//        }
//    }
    public void gameStart(TournamentFighters tour) {
        List<Fighter> semiFinal = new ArrayList<>();
        int listSize = tour.getListSize();
        while (listSize >=2){
            int playerOne = (int) (Math.random() * (tour.getListSize()));
            System.out.println("Lägger till player1 i semi-lista: "+tour.getAFighter(playerOne));
            semiFinal.add(tour.getAFighter(playerOne));
            tour.removeFromTournament(tour.getAFighter(playerOne));
            listSize -= 1;

            int playerTwo = (int) (Math.random() * (tour.getListSize()));
            System.out.println(tour.getAFighter(playerTwo));
            tour.removeFromTournament(tour.getAFighter(playerTwo));
            listSize -= 1;
            System.out.println("------------");
        }
        listSize = semiFinal.size();
        while (listSize >=2){
            int playerOne = (int) (Math.random() * (tour.getListSize()));
            System.out.println("I semifinal: " + semiFinal.get(playerOne));
            //semiFinal.add(tour.getAFighter(playerOne));
            semiFinal.remove(semiFinal.get(playerOne));
            listSize -= 1;

            int playerTwo = (int) (Math.random() * (tour.getListSize()));
            System.out.println("I semifinal: " + semiFinal.get(playerTwo));
            semiFinal.remove(semiFinal.get(playerTwo));
            listSize -= 1;
            System.out.println("------------");
        }
    }
    public void startGame2(TournamentFighters tour){
        while (tour.getListSize() !=0){

        }
    }
}
