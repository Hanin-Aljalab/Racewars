package pr2.vererbung.racewars.racewars.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WesenTest {

    private Wesen wesenUnderTest;

    @BeforeEach
    public void setUp() {
        wesenUnderTest = new Wesen("name", 0.0, 0.0, 0, 0.0, 0) {
            @Override
            public double attacke(Wesen gegner) {
                return 0;
            }
        };
    }

    @Test
    public void testNameGetterAndSetter() {
        final String name = "name";
        wesenUnderTest.setName(name);
        assertEquals(name, wesenUnderTest.getName());
    }

    @Test
    public void testHealthPointsGetterAndSetter() {
        final double healthPoints = 0.0;
        wesenUnderTest.setHealthPoints(healthPoints);
        assertEquals(healthPoints, wesenUnderTest.getHealthPoints(), 0.0001);
    }

    @Test
    public void testSchadenGetterAndSetter() {
        final double schaden = 0.0;
        wesenUnderTest.setSchaden(schaden);
        assertEquals(schaden, wesenUnderTest.getSchaden(), 0.0001);
    }

    @Test
    public void testSpeedGetterAndSetter() {
        final int speed = 0;
        wesenUnderTest.setSpeed(speed);
        assertEquals(speed, wesenUnderTest.getSpeed());
    }

    @Test
    public void testArmorGetterAndSetter() {
        final double armor = 0.0;
        wesenUnderTest.setArmor(armor);
        assertEquals(armor, wesenUnderTest.getArmor(), 0.0001);
    }

    @Test
    public void testPriceGetterAndSetter() {
        final int price = 0;
        wesenUnderTest.setPrice(price);
        assertEquals(price, wesenUnderTest.getPrice());
    }

    @Test
    public void testToString() {
        assertEquals("name", wesenUnderTest.toString());
    }

    @Test
    public void testBeschraenkeSchaden() {
        assertEquals(0.0, wesenUnderTest.beschraenkeSchaden(0.0), 0.0001);
    }

}
