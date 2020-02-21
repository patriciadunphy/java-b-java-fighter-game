package org.program.fighter;

import org.program.db.SQLDatabase;

import java.sql.SQLException;
import java.util.List;

public class FighterController {
    private Fighter model;
    private FighterView view;

    public FighterController(Fighter model, FighterView view) {
        this.model = model;
        this.view = view;
    }

    public void addDefences(String defence) {
        model.addDefences(defence);
    }

    public void setWins(int wins) {
        model.setWins(wins);
    }

    public void updateWins() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int wins = model.getWins() + 1;
        model.setWins(wins);
        db.updateWins(model.getName(),model.getWins());
    }

    public int getWins() {
        return model.getWins();
    }

    public void resetHp() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int hp = db.resetHp(model.getName());
        model.setHp(hp);
    }

    public List<String> getDefences() {
        return model.getDefences();
    }

    public void addAttacks(Attack a) {
        model.addAttacks(a);
    }

    public List<Attack> getAttacks() {
        return model.getAttacks();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void getName() {
        model.getName();
    }

    public void setQuote(String quote) {
        model.setQuote(quote);
    }

    public String getQuote() {
        return model.getQuote();
    }

    public void setHp(int hp) {
        model.setHp(hp);
    }

    public int getHp() {
        return model.getHp();
    }

    public void setSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getSpeed() {
        return model.getSpeed();
    }

    public void setStrength(int strength) {
        model.setStrength(strength);
    }

    public int getStrength() {
        return model.getStrength();
    }

    public void setPower(int power) {
        model.setPower(power);
    }

    public int getPower() {
        return model.getPower();
    }
    public void updateView(){
        view.printFighterDetails(this.model);
    }

}
