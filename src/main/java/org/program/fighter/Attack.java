package org.program.fighter;

public class Attack {
    private String strategyDescription;
    private int damage;

    public Attack setStrategyDescription(String strategyDescription) {
        this.strategyDescription = strategyDescription;
        return this;
    }

    public String getStrategyDescription() {
        return strategyDescription;
    }

    public Attack setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
//        return ("name: " + this.name + ", quote: " + this.quote + "," +
//                " speed: " + this.speed + ", strength: " + this.strength + ", power: " + this.power + ", attacks: " + attacks.toString());
        return ("move: "+this.strategyDescription+", damage: "+damage);
    }
}
