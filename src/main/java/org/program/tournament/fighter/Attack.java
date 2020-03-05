package org.program.tournament.fighter;

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
        return ("move: " + this.strategyDescription + ", damage: " + damage);
    }
}