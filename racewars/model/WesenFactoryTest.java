package pr2.vererbung.racewars.racewars.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import pr2.vererbung.racewars.racewars.controller.Squad;

public class WesenFactoryTest {

    @Test
    public void testCreate() {
        // Setup
        final Rasse rasse = new Rasse("name", 10.0, 10.0, 10, 10.0, 10);
        final Squad playerSquad = new Squad();
        playerSquad.setSquadName("squadName");
        playerSquad.setRestMoney(1000);
        playerSquad.setWesenarray(new Wesen[]{rasse.ORK, rasse.ORK, rasse.MENSCH, rasse.ORK, rasse.ORK});

        // Run the test
        final Wesen[] result = WesenFactory.create(rasse, 1000, playerSquad);
        assertNotEquals(0, result.length);
        // Verify the results
    }


    @Test
    public void testGetLastIndex() {
        // Setup
        final Wesen[] playerSquadArray = new Wesen[]{};

        // Run the test
        final int result = WesenFactory.getLastIndex(playerSquadArray);

        // Verify the results
        assertEquals(0, result);
    }
}
