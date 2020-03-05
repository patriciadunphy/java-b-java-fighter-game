package org.program.tournament.fighter;

import org.program.db.SQLDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fighter constructor
 */
public class Fighter {
    private String name;
    private String quote;
    private int hp;
    private int speed;
    private int strength;
    private int power;
    private int wins;
    private List<Attack> attacks = new ArrayList();
    private List<String> defences = new ArrayList();

    /**
     * Adds a defence to Fighter
     *
     * @param defence
     */
    public void setDefences(String defence) {
        defences.add(defence);
    }

    /**
     * Sets number of wins
     *
     * @param wins
     * @return wins
     */
    public Fighter setWins(int wins) {
        this.wins = wins;
        return this;
    }

    /**
     * Updates number of wins in the database
     *
     * @throws SQLException
     */
    public void updateWins() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int wins;
        wins = this.wins + 1;
        db.updateWins(this.name, wins);
    }

    /**
     * Retrieves wins from the Fighter, this method is not in use atm
     *
     * @return
     */
    public int getWins() {
        return wins;
    }

    /**
     * Resets the fighter's hp
     *
     * @throws SQLException
     */
    public void resetHp() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int hp = db.resetHp(this.name);
        this.hp = hp;
    }

    /**
     * @return defences
     */
    public List<String> getDefences() {
        return defences;
    }

    /**
     * Adding attacks to the fighter
     *
     * @param a
     */
    public void setAttacks(Attack a) {
        attacks.add(a);
    }

    /**
     * Retrieving the fighter's attacks
     *
     * @return attacks
     */
    public List<Attack> getAttacks() {
        return attacks;
    }

    /**
     * Sets the fighter's name
     *
     * @param name
     * @return name
     */
    public Fighter setName(String name) {
        this.name = name;
        return this;
        //notifyListeners(this, FIGHTERNAME, this.name, this.name = name);
        //return this;
    }

    /**
     * Retrieving the fighter's name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the fighter's quote
     *
     * @param quote
     * @return
     */
    public Fighter setQuote(String quote) {
        this.quote = quote;
        return this;
    }

    /**
     * Retrieves the fighter's quote
     *
     * @return
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Setting the fighter's hp
     *
     * @param hp
     * @return
     */
    public Fighter setHp(int hp) {
        this.hp = hp;
        return this;
    }

    /**
     * Retrieving the fighter's hp
     *
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * Setting the fighter's speed
     *
     * @param speed
     * @return
     */
    public Fighter setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    /**
     * Retrieving the fighter's speed, not in use atm
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setting the fighter's strenght
     *
     * @param strength
     * @return
     */
    public Fighter setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    /**
     * Retrieving the fighter's strenght, not in use atm
     *
     * @return
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Setting the fighter's power
     *
     * @param power
     * @return
     */
    public Fighter setPower(int power) {
        this.power = power;
        return this;
    }

    /**
     * Retrieving the fighter's power, not in use atm
     *
     * @return
     */
    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return ("name: " + this.name + ", quote: " + this.quote + "," +
                " speed: " + this.speed + ", strength: " + this.strength + ", power: " + this.power + ", attacks: " + attacks.toString() + ", defences: " + defences.toString() + ", wins: " + this.wins);
    }

    /**
     * Method for when a fighter attacks
     *
     * @param chosenAttack
     * @return damage
     */
    public int attack(int chosenAttack) {
        int damage = this.attacks.get(chosenAttack).getDamage();
        return damage;
    }

    /**
     * Method for when a fighter is attacked
     *
     * @param damage
     */
    public void receiveAttack(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    /**
     * Method for when a fighter defends itself
     *
     * @param chosenDefence
     * @return
     */
    public String defend(int chosenDefence) {
        return this.defences.get(chosenDefence);
    }
}