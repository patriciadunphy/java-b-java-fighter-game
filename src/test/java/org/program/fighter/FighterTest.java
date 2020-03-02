package org.program.fighter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    static Fighter a = new Fighter();
    static Attack attack = new Attack();
    @BeforeAll
    static void setup(){
        attack = new Attack();
        attack.setStrategyDescription("Kick");
        attack.setDamage(10);
        a.setName("Anna Williams");
        a.setQuote("Yay, win!");
        a.setPower(100);
        a.setHp(100);
        a.setStrength(100);
        a.setSpeed(100);
        a.setWins(5);
        a.setDefences("Crying");
        a.setAttacks(attack);
    }

    /**
     * Test to check if Hp changes after successful attack
     */
    @Test
    void receiveAttack() {
        a.receiveAttack(20);
        assertEquals(80, a.getHp());
    }

//    @Test
//    void addDefences() {
//    }
//
//    @Test
//    void setWins() {
//
//    }
//
//    @Test
//    void updateWins() {
//    }
//
//    @Test
//    void getWins() {
//    }
//
//    @Test
//    void resetHp() {
//    }
//
//    @Test
//    void getDefences() {
//    }
//
//    @Test
//    void addAttacks() {
//    }
//
//    @Test
//    void getAttacks() {
//    }
//
//    @Test
//    void setName() {
//    }
//
//    @Test
//    void getName() {
//    }
//
//    @Test
//    void setQuote() {
//    }
//
//    @Test
//    void getQuote() {
//    }
//
//    @Test
//    void setHp() {
//    }
//
    @Test
    void getHp() {
        assertEquals(100, a.getHp());
    }
//
//    @Test
//    void setSpeed() {
//    }
//
//    @Test
//    void getSpeed() {
//    }
//
//    @Test
//    void setStrength() {
//    }
//
//    @Test
//    void getStrength() {
//    }
//
//    @Test
//    void setPower() {
//    }
//
//    @Test
//    void getPower() {
//    }
//
//    @Test
//    void attack() {
//    }
//
//    @Test
//    void testReceiveAttack() {
//    }
//
//    @Test
//    void defend() {
//    }
}