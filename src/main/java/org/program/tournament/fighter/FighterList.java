package org.program.tournament.fighter;

import org.program.db.SQLDatabase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FighterList {
    public static final String FIGHTERNAME = "fighterName";
    private List<Fighter> fighters = new ArrayList<>();
    private List<PropertyChangeListener> listener = new ArrayList<>();

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
        notifyListeners(this, FIGHTERNAME, null, fighter.getName());
    }

    public void removeFighter(int i) {
        fighters.remove(i);
    }

    public int getSize() {
        int size = this.fighters.size();
        return size;
    }

    public Fighter getFighter(int i) {
        return fighters.get(i);
    }

    public void createTournamentList() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        List<Fighter> fighters = new ArrayList<Fighter>();
        /**
         * Fetching fighters from db and putting them in Tournament Fighters list
         */
        fighters.addAll(db.getFighters());
        db.closeConnection(db.getConnection());
        /**
         * Shuffles the fighters in the list
         */
        Collections.shuffle(fighters);
        this.fighters = fighters;
    }

    private void notifyListeners(Object object, String property, String oldValue, String newValue) {
        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void addChangeListener(PropertyChangeListener newListener) {
        listener.add(newListener);
    }
}
