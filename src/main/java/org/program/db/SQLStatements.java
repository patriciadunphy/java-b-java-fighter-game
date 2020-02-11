package org.program.db;

public class SQLStatements {

    public String selectAllFighters() {
        String allFighters = "select f.name, f.quote, f.hp, f.power, f.speed, f.strength " +
                "from fighter as f";
        return allFighters;
    }

    public String getAllAttacks() {
        String allAttacks = "SELECT a.strategy_description, a.damage, f.name " +
                "FROM attack AS a " +
                "LEFT JOIN fighter_attack AS fa " +
                "ON fa.fk_attack_id = a.attack_id " +
                "LEFT JOIN fighter AS f " +
                "ON f.fighter_id = fa.fk_fighter_id";
        return allAttacks;
    }

    public String selectSpecificFighter() {
        String fighter = "select f.name, f.hp, f.power, f.speed, f.strength " +
                "from fighter as f " +
                "where name like ?";
        return fighter;
    }

    public String selectDefenceStrategies() {
        String defence = "SELECT d.strategy_description, f.name FROM defend AS d " +
                "LEFT JOIN fighter_defend AS fd ON fd.fk_defend_id = d.defend_id " +
                "LEFT JOIN fighter AS f ON f.fighter_id = fd.fk_fighter_id";
        return defence;
    }
}
