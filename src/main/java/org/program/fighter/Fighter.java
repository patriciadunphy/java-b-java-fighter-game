package org.program.fighter;

public class Fighter {
    private String name;
    private String quote;
    private int hp;
    private int speed;
    private int strength;
    private int power;

    public Fighter setName(String name) {
        this.name = name;
        return this;
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
    public Fighter setStrength(int strength){
        this.strength = strength;
        return this;
    }
    public Fighter setPower(int power){
        this.power = power;
        return this;
    }

}
