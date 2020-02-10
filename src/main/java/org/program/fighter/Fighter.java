package org.program.fighter;

public class Fighter implements FighterMethods{
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
    @Override
    public String toString(){
        return("name: "+this.name+", quote: "+this.quote+"," +
                " speed: "+this.speed+", strength: "+this.strength+", power: "+this.power);
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public int attack(int damage) {
        return 0;
    }

}
