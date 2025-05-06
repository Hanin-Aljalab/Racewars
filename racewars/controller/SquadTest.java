package pr2.vererbung.racewars.racewars.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pr2.vererbung.racewars.racewars.model.Wesen;

public class SquadTest {

    private Squad squadUnderTest;

    @BeforeEach
    public void setUp() {
        squadUnderTest = new Squad();
    }

    @Test
    public void testSquadNameGetterAndSetter() {
        final String squadName = "squadName";
        squadUnderTest.setSquadName(squadName);
        assertEquals(squadName, squadUnderTest.getSquadName());
    }

    @Test
    public void testRestMoneyGetterAndSetter() {
        final int restMoney = 0;
        squadUnderTest.setRestMoney(restMoney);
        assertEquals(restMoney, squadUnderTest.getRestMoney());
    }

    @Test
    public void testWesenarrayGetterAndSetter() {
        final Wesen[] wesenarray = new Wesen[]{};
        squadUnderTest.setWesenarray(wesenarray);
        assertArrayEquals(wesenarray, squadUnderTest.getWesenarray());
    }

    @Test
    public void testRemoveDeadCreature() {
        // Setup
        final Squad squad = new Squad();
        squad.setSquadName("squadName");
        squad.setRestMoney(0);
        squad.setWesenarray(new Wesen[]{});

        // Run the test
        squadUnderTest.removeDeadCreature(squad, 0);

        // Verify the results
    }

    @Test
    public void testGetSquadNumber() {
        assertEquals(0, squadUnderTest.getSquadNumber());
    }


}
