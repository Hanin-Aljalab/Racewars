package pr2.vererbung.racewars.racewars.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pr2.vererbung.racewars.racewars.model.Wesen;

public class GameControllerTest {

    private GameController gameControllerUnderTest;

    @BeforeEach
    public void setUp() {
        gameControllerUnderTest = new GameController();
    }

    @Test
    public void testMain() {
        // Setup
        // Run the test
        GameController.main(new String[]{"args"});

        // Verify the results
    }

    @Test
    public void testPlayerInput() {
        // Setup
        final Squad team = new Squad();
        team.setSquadName("squadName");
        team.setRestMoney(0);
        team.setWesenarray(new Wesen[]{});

        // Run the test
        gameControllerUnderTest.playerInput(0, team);

        // Verify the results
    }

    @Test
    public void testCheckWinner() {
        // Setup
        final Squad teamOne = new Squad();
        teamOne.setSquadName("squadName");
        teamOne.setRestMoney(0);
        teamOne.setWesenarray(new Wesen[]{});

        final Squad teamTwo = new Squad();
        teamTwo.setSquadName("squadName");
        teamTwo.setRestMoney(0);
        teamTwo.setWesenarray(new Wesen[]{});

        // Run the test
        final int result = gameControllerUnderTest.checkWinner(teamOne, teamTwo);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    public void testRunGame() {
        // Setup
        final Squad teamOne = new Squad();
        teamOne.setSquadName("squadName");
        teamOne.setRestMoney(0);
        teamOne.setWesenarray(new Wesen[]{});

        final Squad teamTwo = new Squad();
        teamTwo.setSquadName("squadName");
        teamTwo.setRestMoney(0);
        teamTwo.setWesenarray(new Wesen[]{});

        // Run the test
        gameControllerUnderTest.runGame(teamOne, teamTwo);

        // Verify the results
    }

    @Test
    public void testGameRound() {
        // Setup
        final Squad teamOne = new Squad();
        teamOne.setSquadName("squadName");
        teamOne.setRestMoney(0);
        teamOne.setWesenarray(new Wesen[]{});

        final Squad teamTwo = new Squad();
        teamTwo.setSquadName("squadName");
        teamTwo.setRestMoney(0);
        teamTwo.setWesenarray(new Wesen[]{});

        // Run the test
        gameControllerUnderTest.gameRound(teamOne, teamTwo, 0);

        // Verify the results
    }
}
