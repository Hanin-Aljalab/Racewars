package pr2.vererbung.racewars.racewars.viewer;

import pr2.vererbung.racewars.racewars.controller.Squad;

/**
 * Die Klasse GameViewer dient zum Anzeigen des aktuellen Spielzustands und des Gewinners des Spiels.
 */
public final class GameViewer {

    /**
     * Gib den aktuellen Stand des Spieles aus. Hierzu greift die
     * Methode auf die Methoden des Gamecontrollers zurück.
     *
     * @param game das Spiel
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
     * Gibt den Gewinner des Spiels aus oder zeigt an, dass das Spiel unentschieden ist.
     *
     * @param winnerNumber Die Nummer des Gewinnerteams (1 für Team 1, 2 für Team 2).
     * @param teamOne Das erste Team.
     * @param teamTwo Das zweite Team.
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
