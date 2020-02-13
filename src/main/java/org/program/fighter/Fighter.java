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

    public void addDefences(String defence) {
        defences.add(defence);
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
                " speed: " + this.speed + ", strength: " + this.strength + ", power: " + this.power + ", attacks: " + attacks.toString() + ", defences: " + defences.toString());
    }

    @Override
    public void defend(int chosenDefence, int damage) {
        System.out.println(this.name+" choose to defend with a "+this.defences.get(chosenDefence));
        int chance = (int) (Math.random() * (1 - 10)) + 10;
        if (chance > 2) {
            System.out.println("The attack caused " + damage+" HP in damage.");
            this.hp -= damage;
            //Lägg till logik: ifall HP blir under 0 sätt HP till 0.
            if (this.getHp() > 0)
            System.out.println("Current HP: " + this.getHp());
            else
                System.out.println(this.name+" was defeated.");
        } else {
            System.out.println("Attack blocked, HP stays unchanged.");
        }
    }

    @Override
    public int attack(int chosenAttack) {
        System.out.println(this.name+" attacks with a "+this.attacks.get(chosenAttack).getStrategyDescription());
        int damage = this.attacks.get(chosenAttack).getDamage();
        return damage;
    }

}
