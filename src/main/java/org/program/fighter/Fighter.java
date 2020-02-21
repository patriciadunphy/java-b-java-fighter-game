package org.program.fighter;

import org.program.db.SQLDatabase;
import org.program.db.SQLStatements;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Fighter implements FighterMethods {
    private String name;
    private String quote;
    private int hp;
    private int speed;
    private int strength;
    private int power;
    private int wins;
    private List<Attack> attacks = new ArrayList();
    private List<String> defences = new ArrayList();

    public void addDefences(String defence) {
        defences.add(defence);
    }

    public Fighter setWins(int wins) {
        this.wins = wins;
        return this;
    }
    public void updateWins() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int wins;
        wins = this.wins+1;
        db.updateWins(this.name, wins);
    }
    public int getWins(){
        return wins;
    }

    public void resetHp() throws SQLException {
        SQLDatabase db = SQLDatabase.getInstance();
        int hp = db.resetHp(this.name);
        this.hp = hp;
    }

    public List<String> getDefences() {
        return defences;
    }

    public void addAttacks(Attack a) {
        attacks.add(a);
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public Fighter setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Fighter setQuote(String quote) {
        this.quote = quote;
        return this;
    }

    public String getQuote() {
        return quote;
    }

    public Fighter setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Fighter setSpeed(int speed) {
        this.speed = speed;
        return this;
    }
    public int getSpeed(){
        return speed;
    }

    public Fighter setStrength(int strength) {
        this.strength = strength;
        return this;
    }
    public int getStrength(){
        return strength;
    }

    public Fighter setPower(int power) {
        this.power = power;
        return this;
    }
    public int getPower(){
        return power;
    }

    @Override
    public String toString() {
        return ("name: " + this.name + ", quote: " + this.quote + "," +
                " speed: " + this.speed + ", strength: " + this.strength + ", power: " + this.power + ", attacks: " + attacks.toString() + ", defences: " + defences.toString()+ ", wins: "+this.wins);
    }

    @Override
    public int attack(int chosenAttack) {
        System.out.println(this.name + " attacks with a " + this.attacks.get(chosenAttack).getStrategyDescription());
        int damage = this.attacks.get(chosenAttack).getDamage();
        return damage;
    }

    public void receiveAttack(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.name + " didn't block the attack, current HP: " + this.hp);
    }

    @Override
    public void defend(int chosenDefence) {
        System.out.println(this.name + " choose to defend with a " + this.defences.get(chosenDefence) + "\nHP stays unchanged.");
    }
}


