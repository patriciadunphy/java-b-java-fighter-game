package org.program.fighter;

import java.util.ArrayList;
import java.util.List;

public class Fighter implements FighterMethods {
    private String name;
    private String quote;
    private int hp;
    private int speed;
    private int strength;
    private int power;
    private List<Attack> attacks = new ArrayList();
    private List<String> defences = new ArrayList();

    public void addDefences(String defence){
        defences.add(defence);
    }
    public List<String> getDefences(){
        return defences;
    }

    public void addAttacks(Attack a) {
        attacks.add(a);
    }
    public List<Attack> getAttacks(){
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

    public Fighter setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public Fighter setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public Fighter setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public Fighter setPower(int power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        return ("name: " + this.name + ", quote: " + this.quote + "," +
                " speed: " + this.speed + ", strength: " + this.strength + ", power: " + this.power +", attacks: "+attacks.toString()+", defences: "+defences.toString());
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public int attack(int damage) {
        return damage;
    }

}
