import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ShippTest {
    private Ship fdShipp;
    private Ship bpShipp;
    private Ship sShipp;
    private Ship bShipp;

    @BeforeEach
    public void initializeShipp() {
        fdShipp = new Ship(10, "Flying Dutchman");
        bpShipp = new Ship(5, "Black Pearl");
        sShipp = new Ship(0, "Sunken Shipp");
        bShipp = new Ship(1, "broken shipp");
    }

    @Test
    void testTostring() {
        assertEquals("The Sunken Shipp has 0 PV.", sShipp.toString());
        assertEquals("The Flying Dutchman has 10 PV.", fdShipp.toString());

    }

    @Test
    void testIsAliveShip() {
        assertTrue(sShipp.hasBeenSunk());
        assertFalse(bShipp.hasBeenSunk());
    }

    @Test
    void testTakingDamage() {
        fdShipp.takeAHit();
        fdShipp.takeAHit();
        assertEquals(fdShipp.getShippLifePoints(), 8);
        bpShipp.takeAHit();
        assertEquals(bpShipp.getShippLifePoints(), 4);
        bShipp.takeAHit();
        assertTrue(bShipp.hasBeenSunk());
    }
}