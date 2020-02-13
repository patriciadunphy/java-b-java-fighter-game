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
//    public void gameStart(TournamentFighters tour) {
//        List<Fighter> semiFinal = new ArrayList<>();
//        int listSize = tour.getListSize();
//        while (listSize >=2){
//            int playerOne = (int) (Math.random() * (tour.getListSize()));
//            System.out.println("Lägger till player1 i semi-lista: "+tour.getAFighter(playerOne));
//            semiFinal.add(tour.getAFighter(playerOne));
//            tour.removeFromTournament(tour.getAFighter(playerOne));
//            listSize -= 1;
//
//            int playerTwo = (int) (Math.random() * (tour.getListSize()));
//            System.out.println(tour.getAFighter(playerTwo));
//            tour.removeFromTournament(tour.getAFighter(playerTwo));
//            listSize -= 1;
//            System.out.println("------------");
//        }
//        listSize = semiFinal.size();
//        while (listSize >=2){
//            int playerOne = (int) (Math.random() * (tour.getListSize()));
//            System.out.println("I semifinal: " + semiFinal.get(playerOne));
//            //semiFinal.add(tour.getAFighter(playerOne));
//            semiFinal.remove(semiFinal.get(playerOne));
//            listSize -= 1;
//
//            int playerTwo = (int) (Math.random() * (tour.getListSize()));
//            System.out.println("I semifinal: " + semiFinal.get(playerTwo));
//            semiFinal.remove(semiFinal.get(playerTwo));
//            listSize -= 1;
//            System.out.println("------------");
//        }
//    }
    public void startGame2(TournamentFighters tour) {
        int listSize = tour.getListSize();
        Fighter player1;
        Fighter player2;
        int player1wins = 0;
        int player2wins = 0;
        while (tour.getListSize() != 0) {
            //Skapar ett random nummer mellan 0 och tour-listans storlek
            int iPlayer1 = (int) (Math.random() * (tour.getListSize()));
            //Skapar ett nytt fighter-objekt och kopierar in fightern som finns på positionen iPlayer1
            player1 = tour.getAFighter(iPlayer1);
            //Tar bort fightern från tour-listan
            tour.removeFromTournament(tour.getAFighter(iPlayer1));
            //Gör detsamma för player2
            int iPlayer2 = (int) (Math.random() * (tour.getListSize()));
            player2 = tour.getAFighter(iPlayer2);
            tour.removeFromTournament(tour.getAFighter(iPlayer2));
            //Så länge som en av spelarna inte har 0 i hp
//            boolean playerIsDead = false;

            //loop för tre ronder
            for (int i = 1; i < 4; i++) {
                boolean playerIsDead = false;
                System.out.println("Round: " + i);
                while (playerIsDead == false) {
                    //Här läggs scanner till
                    int playerDefence;
                    int playerAttack;
                    player2.defend(playerDefence = 2, player1.attack(playerAttack = 1));
                    if (player2.getHp() <= 0){
                        player1wins += 1;
                        playerIsDead = true;

                        //player2.setHp(0);
                    } else {
                        player1.defend(playerDefence = 2, player2.attack(playerAttack = 2));
                        if (player1.getHp() <= 0) {
                            player2wins += 1;
                            playerIsDead = true;

                            //player1.setHp(0);
                        }
                    }

                }
                //Återställer hp till nästa rond
                player1.setHp(100);
                player2.setHp(100);
            } if (player1wins > player2wins){
                System.out.println("player1 läggs till i ny lista");
                //lägg till player1 i ny lista
            } else if (player2wins > player1wins){
                System.out.println("player2 läggs till i ny lista");
                //lägg till player2 i ny lista
            } else {
                System.out.println("Something went wrong in the fight");
            }


        }
    }
}
