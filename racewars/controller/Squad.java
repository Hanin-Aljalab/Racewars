package pr2.vererbung.racewars.racewars.controller;


import java.util.ArrayList;

import java.util.List;

import java.util.Random;


import pr2.vererbung.racewars.racewars.model.Wesen;


/**
 * The Squad class represents a group of creatures used for battle in the game.
 */

public final class Squad {


    /**
     * Maximum available funds for purchasing creatures for the squad.
     */

    public static final int MAX_INVEST = 2000;


    /**
     * The name of the squad.
     */
    public String squadName;


    /**
     * The remaining funds of the squad.
     */
    public int restMoney;


    /**
     * The array of creatures in the squad.
     */
    public Wesen[] wesenarray;


    /**
     * Constructor for the Squad class.
     */

    public Squad() {

        this.squadName = squadName;

        this.restMoney = restMoney;

        this.wesenarray = new Wesen[50]; // Initialisiere das Array mit der maximalen Anzahl von Rassen

    }


    /**
     * Returns the name of the squad.
     *
     * @return The name of the squad.
     */

    public String getSquadName() {

        return squadName;

    }


    /**
     * Sets the name of the squad.
     *
     * @param squadName The new name of the squad.
     */

    public void setSquadName(String squadName) {

        this.squadName = squadName;

    }


    /**
     * Returns the remaining funds of the squad.
     *
     * @return The remaining funds.
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
     * Returns the array of creatures in the squad.
     *
     * @return The array of creatures.
     */

    public Wesen[] getWesenarray() {

        return wesenarray;

    }


    /**
     * Sets the array of creatures in the squad.
     *
     * @param wesenarray The new array of creatures.
     */

    public void setWesenarray(Wesen[] wesenarray) {

        this.wesenarray = wesenarray;

    }


    /**
     * Removes a dead creature from the squad.
     *
     * @param squad The squad from which the creature should be removed.
     * @param index The index of the creature to be removed.
     */

    public void removeDeadCreature(Squad squad, int index) {

        // Check if squad size is greater than 0
        if (squad.getSquadNumber() > 0) {

            Wesen[] newwesenarray = new Wesen[squad.wesenarray.length - 1];


            for (int i = 0, j = 0; i < squad.wesenarray.length; i++) {

                // Skip the creature to be removed
                if (i != index) {

                    newwesenarray[j++] = squad.wesenarray[i];

                }

            }

            squad.wesenarray = newwesenarray;

        } else {

            // Handle case when squad size is already 0 or less
            // You may log a warning, throw an exception, etc.

            System.out.println("Die Squad-Nummer ist bereits 0 oder kleiner.");

        }


    }


    /**
     * Returns the number of creatures currently in the squad.
     *
     * @return The number of creatures.
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
     * Checks whether the squad is empty.
     *
     * @return True if the squad has no members, otherwise false.
     */

    public boolean squadIsEmpty() {

        return getSquadNumber() <= 0;

    }


}

