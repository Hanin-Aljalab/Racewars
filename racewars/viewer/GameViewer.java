package pr2.vererbung.racewars.racewars.viewer;

import pr2.vererbung.racewars.racewars.controller.Squad;

/**
 * The GameViewer class is responsible for displaying the current game state and the winner.
 */
public final class GameViewer {

    /**
     * Displays the current state of the game by printing the squad's name, size, and member names.
     *
     * @param team the squad whose state is to be displayed
     */

    public static void printGame(Squad team) {
        System.out.println("Squad von: " + team.getSquadName());

        System.out.println("Squadgröße: " + team.getSquadNumber());

        for (int i = 0; i < team.wesenarray.length; i++) {
            if (team.wesenarray[i] != null) {
                System.out.println(team.wesenarray[i].getName());
            }
        }
    }

    /**
     * Prints the winner of the game or declares a draw if there is no winner.
     *
     * @param winnerNumber the number of the winning team (1 for team one, 2 for team two)
     * @param teamOne      the first team
     * @param teamTwo      the second team
     */

    public static void printWinner(int winnerNumber, Squad teamOne, Squad teamTwo) {
        if (winnerNumber == 1) {
            System.out.println("SIEGER: " + teamOne.getSquadName());
        } else if (winnerNumber == 2) {
            System.out.println("SIEGER: " + teamTwo.getSquadName());
        } else {
            System.out.println("UNENTSCHIEDEN!");
        }
    }


}
