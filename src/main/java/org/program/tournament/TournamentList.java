package org.program.tournament;

import org.program.db.SQLDatabase;
import org.program.fighter.Fighter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentList {
    private List<Fighter> fighterList = createTournamentList();

    public TournamentList() throws SQLException {
    }
    public List<Fighter> getTournamentList(){
      return fighterList;
    }
    //Call the database, gets fighters och places them in a list, the list is returned
    private List<Fighter> createTournamentList() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        List<Fighter> fighters = new ArrayList<Fighter>();
        //---Fetching fighters from db and putting them in Tournament Fighters list---
        fighters.addAll(db.getFighters());
        db.closeConnection(db.getConnection());
        //Shuffles the fighters in the list
        Collections.shuffle(fighters);
        return fighters;
    }
}
