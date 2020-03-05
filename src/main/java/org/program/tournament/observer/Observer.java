package org.program.tournament.observer;

import org.program.tournament.fighter.FighterList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Observer implements PropertyChangeListener {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Observer(FighterList model) {
        model.addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

        System.out.println(ANSI_PURPLE + "Coming up: " + event.getNewValue() + ANSI_WHITE);
    }
}