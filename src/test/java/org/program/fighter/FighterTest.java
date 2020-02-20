package org.program.fighter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {

    //Test to check if Hp changes after successful attack
    @Test
    void receiveAttack() {
        Fighter a = new Fighter();
        a.setHp(100);
        a.receiveAttack(20);
        assertEquals(80, a.getHp());
    }
}