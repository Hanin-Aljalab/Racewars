package pr2.vererbung.racewars.racewars.viewer;

import org.junit.jupiter.api.Test;

import pr2.vererbung.racewars.racewars.controller.Squad;
import pr2.vererbung.racewars.racewars.model.Wesen;

public class GameViewerTest {

    @Test
    public void testPrintGame() {
        // Setup
        final Squad team = new Squad();
        team.setSquadName("squadName");
        team.setRestMoney(0);
        team.setWesenarray(new Wesen[]{});

        // Run the test
        GameViewer.printGame(team);

        // Verify the results
    }

    @Test
    public void testPrintWinner() {
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
        GameViewer.printWinner(0, teamOne, teamTwo);

        // Verify the results
    }
}
