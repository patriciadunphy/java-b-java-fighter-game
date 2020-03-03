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
        a.setStrength(70);
        a.setSpeed(30);
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

    @Test
    void getHp() {
        assertEquals(100, a.getHp());
    }

    @Test
    void setSpeed() {
        a.setSpeed(30);
        assertEquals(30, a.getSpeed());
    }

    @Test
    void getSpeed() {
        assertEquals(30, a.getSpeed());
    }

    @Test
    void setStrength() {
        a.setStrength(40);
        assertEquals(40, a.getStrength());
    }

    @Test
    void getStrength() {
        assertEquals(70, a.getStrength());
    }

    @Test
    void setPower() {
        a.setPower(50);
        assertEquals(50, a.getPower());
    }

    @Test
    void getPower() {
        assertEquals(100, a.getPower());
    }

    @Test
    void attack() {
        assertEquals(10, a.getAttacks().get(0).getDamage());
    }

    /**
     * Test to check that an exception is thrown when trying to get an attack that doesn't exists.
     */
    @Test
    void attack_fail() {
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            a.getAttacks().get(1).getDamage();
        });
    }

    @Test
    void defend() {
        assertNotNull(a.getDefences());
    }
}