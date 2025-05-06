package pr2.vererbung.racewars.racewars.controller;



import java.util.ArrayList;

import java.util.List;

import java.util.Random;



import pr2.vererbung.racewars.racewars.model.Wesen;



/**

 * Die Klasse Squad repräsentiert eine Gruppe von Wesen für den Kampf im Spiel.

 */

public final class Squad {



	/**

	 * Maximal vorhandenes Geld für das Kaufen von Wesen für das Squad.

	 */

	public static final int MAX_INVEST = 2000;

	

	/** Der Name des Squads. */

	public String squadName;

	

	/** Das restliche Geld des Squads. */

	public int restMoney;

	

	 /** Das Array von Wesen im Squad. */

	public Wesen[] wesenarray;



    /**

     * Konstruktor für die Squad-Klasse.

     */

	public Squad() {

		this.squadName = squadName;

		this.restMoney = restMoney;

		this.wesenarray = new Wesen[50]; // Initialisiere das Array mit der maximalen Anzahl von Rassen

	}



    /**

     * Gibt den Namen des Squads zurück.

     *

     * @return Der Name des Squads.

     */

	public String getSquadName() {

		return squadName;

	}



    /**

     * Setzt den Namen des Squads.

     *

     * @param squadName Der neue Name des Squads.

     */

	public void setSquadName(String squadName) {

		this.squadName = squadName;

	}



    /**

     * Gibt das restliche Geld des Squads zurück.

     *

     * @return Das restliche Geld des Squads.

     */

	public int getRestMoney() {

		return restMoney;

	}



    /**

     * Setzt das restliche Geld des Squads.

     *

     * @param restMoney Das neue restliche Geld des Squads.

     */

	public void setRestMoney(int restMoney) {

		this.restMoney = restMoney;

	}



    /**

     * Gibt das Array von Wesen im Squad zurück.

     *

     * @return Das Array von Wesen im Squad.

     */

	public Wesen[] getWesenarray() {

		return wesenarray;

	}



    /**

     * Setzt das Array von Wesen im Squad.

     *

     * @param wesenarray Das neue Array von Wesen im Squad.

     */

	public void setWesenarray(Wesen[] wesenarray) {

		this.wesenarray = wesenarray;

	}

    /**

     * Entfernt ein totes Wesen aus dem Squad.

     *

     * @param squad Das Squad, aus dem das Wesen entfernt werden soll.

     * @param index Der Index des zu entfernenden Wesens im Squad.

     */

	public void removeDeadCreature(Squad squad, int index) {

		// Überprüfen, ob die Squad-Nummer größer als 0 ist

		if (squad.getSquadNumber() > 0) {

			Wesen[] newwesenarray = new Wesen[squad.wesenarray.length - 1];



			for (int i = 0, j = 0; i < squad.wesenarray.length; i++) {

				// Index vom Wesen, das stirbt, überspringen

				if (i != index) {

					newwesenarray[j++] = squad.wesenarray[i];

				}

			}

			squad.wesenarray = newwesenarray;

		} else {

			// Behandlung für den Fall, dass die Squad-Nummer kleiner oder gleich 0 ist

			// Hier kannst du entscheiden, was in diesem Fall passieren soll

			// Zum Beispiel eine Fehlermeldung ausgeben, einen Fehler werfen, etc.

			System.out.println("Die Squad-Nummer ist bereits 0 oder kleiner.");

		}



	}

	

    /**

     * Gibt die Anzahl der Wesen im Squad zurück.

     *

     * @return Die Anzahl der Wesen im Squad.

     */

	public int getSquadNumber() {

		int counter = 0;

		for (int i = 0; i < wesenarray.length; i++) {

			if (wesenarray[i] != null) {

				counter++;

			}

		}

		if (counter < 0) {

			return 0;

		}

		return counter;

	}

	

    /**

     * Überprüft, ob das Squad noch Mitglieder hat.

     *

     * @return True, wenn das Squad keine Mitglieder hat, ansonsten False.

     */

    public boolean squadIsEmpty() {

        return getSquadNumber() <= 0;

    }

    

    



}

