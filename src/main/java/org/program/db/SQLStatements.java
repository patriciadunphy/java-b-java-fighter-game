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
        String defence = "SELECT d.strategy_description FROM defend AS d " +
                "LEFT JOIN fighter_defend AS fd ON fd.fk_defend_id = d.defend_id " +
                "LEFT JOIN fighter AS f ON f.fighter_id = fd.fk_fighter_id " +
                "WHERE f.name LIKE ?";
        return defence;
    }

//    public String selectAttackStrategies() {
//        String attack = "SELECT a.strategy_description, a.damage FROM attack AS a " +
//                "LEFT JOIN fighter_attack AS fa ON fa.fk_attack_id = a.attack_id " +
//                "LEFT JOIN fighter AS f ON f.fighter_id = fa.fk_fighter_id " +
//                "WHERE f.name LIKE ?";
//        return attack;
//    }


//    public String selectActor() {
//        String selectActor = "select * from actor where last_name like ? and first_name like ? order by last_name";
//        return selectActor;
//    }
//
//    public String insertActor() {
//        String insertActor = "insert into actor (last_name, first_name, last_update) values (?, ?, CURDATE())";
//        return insertActor;
//    }
//
//    public String updateActor() {
//        String updateActor = "update actor set last_name = ?, first_name = ? where last_name = ? and first_name = ?";
//        return updateActor;
//    }
//
//    public String deleteActor() {
//        String deleteActor = "delete from actor where last_name = ? and first_name = ?";
//        return deleteActor;
//    }
//
//    public String selectFilmsFromActor() {
//        String selectFilms = "select a.first_name, a.last_name, f.title, f. release_year from actor as a\n"
//                + "left join film_actor as fa on a.actor_id = fa.actor_id\n"
//                + "left join film as f on fa.film_id = f.film_id\n"
//                + "where last_name like ? and first_name like ?" + "order by release_year desc;";
//        return selectFilms;
//    }
}
