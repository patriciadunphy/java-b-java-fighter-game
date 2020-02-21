package org.program.fighter;

public class FighterView {
    public void printFighterDetails(Fighter model){
        System.out.println("name: " + model.getName() + ", quote: " + model.getQuote() + "," +
                " speed: " + model.getSpeed() + ", strength: " + model.getStrength() +
                ", power: " + model.getPower() + ", attacks: " + model.getAttacks()
                + ", defences: " + model.getDefences() + ", wins: " + model.getWins());
    }
}
