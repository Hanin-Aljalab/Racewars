package pr2.vererbung.racewars.racewars.model;

import pr2.vererbung.racewars.racewars.controller.Squad;

/**
 * Factory class for creating and purchasing creatures (Wesen).
 */
public final class WesenFactory {

    /**
     * This method takes the race and the budget to create an array of creatures.
     * The first element is always the leader, followed by standard race creatures.
     * If the budget is insufficient, an empty array is returned.
     *
     * @param rasse The race of the creatures to be created.
     * @param budget The budget to be invested.
     * @param playerSquad The player's squad to which creatures will be added.
     * @return An array of creatures, with the first element being the leader.
     */
    public static Wesen[] create(Rasse rasse, int budget, Squad playerSquad) {

        Anfuehrer leader = null;
        int leaderPrice = 0;

        if (rasse instanceof Ork) {
            leader = new Anfuehrer("Farseer", rasse, Element.ERDE, 1.2);
            leaderPrice = leader.getPrice();
        } else if (rasse instanceof Mensch) {
            leader = new Anfuehrer("Erzmagier", rasse, Element.FEUER, 5.0);
            leaderPrice = leader.getPrice();
        } else if (rasse instanceof Nachtelf) {
            leader = new Anfuehrer("Daemonslayer", rasse, Element.LUFT, 3.0);
            leaderPrice = leader.getPrice();
        } else if (rasse instanceof Untote) {
            leader = new Anfuehrer("Lich", rasse, Element.WASSER, 2.3);
            leaderPrice = leader.getPrice();
        }

        // CREATE LEADER FOR THE RACE

        // Check which specific race is used
        int lastIndex = getLastIndex(playerSquad.wesenarray);
        int restMoney = budget;

        if (playerSquad.wesenarray[0] == null || !playerSquad.wesenarray[0].equals(leader)) {
            if (budget < leaderPrice) {
                playerSquad.wesenarray[lastIndex] = null;
            } else {
                restMoney = budget - leaderPrice;
                playerSquad.wesenarray[lastIndex] = leader;
            }
        } else {
            if (restMoney < leaderPrice) {
                playerSquad.wesenarray[lastIndex] = null;
            } else {
                playerSquad.wesenarray[lastIndex] = leader;
            }
        }

        // CREATE ADDITIONAL CREATURES OF THE RACE

        if (restMoney < rasse.getPrice()) {
            return playerSquad.wesenarray;
        }

        int amountRace = restMoney / rasse.getPrice(); // e.g., 700/150 = 4
        restMoney = restMoney - (amountRace * rasse.getPrice()); // e.g., 700 - (4*150) = 100
        playerSquad.setRestMoney(restMoney);

        // Buy remaining creatures
        for (int i = lastIndex + 1; i <= lastIndex + amountRace; i++) {
//				playerSquad.wesenarray[i] = new Ork();
            if (rasse instanceof Ork) {
                playerSquad.wesenarray[i] = new Ork();
            } else if (rasse instanceof Mensch) {
                playerSquad.wesenarray[i] = new Mensch();
            } else if (rasse instanceof Nachtelf) {
                playerSquad.wesenarray[i] = new Nachtelf();
            } else if (rasse instanceof Untote) {
                playerSquad.wesenarray[i] = new Untote();
            }
        }

        return playerSquad.wesenarray;

    }

    /**
     * Determines the index of the last non-null element in the array.
     *
     * @param playerSquadArray The array to search.
     * @return The index of the last non-null element.
     */

    public static int getLastIndex(Wesen[] playerSquadArray) {
        int lastIndex = 0; // Initialize the index

        // Loop through the array to find the last non-null index
        for (int i = 0; i < playerSquadArray.length; i++) {
            if (playerSquadArray[i] == null) {
                lastIndex = i; // Update the last non-null index
                return lastIndex;
            }
        }
        return lastIndex;
    }

}
