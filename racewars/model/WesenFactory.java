package pr2.vererbung.racewars.racewars.model;

import pr2.vererbung.racewars.racewars.controller.Squad;

/**
 * Klasse, um Wesen zu kaufen und zu erzeugen.
 */
public final class WesenFactory {

    /**
     * Der Methode übergibt man die Information, wie viel Geld man investieren
     * möchte und sie gibt ein Array von Wesen zurück. Das erste Element ist immer
     * der Anführer, die folgenden dann entsprechend die Wesen der Art. Reicht das
     * Geld nicht, wird ein leeres Array zurückgegeben. Die Art der erzeugten Wesen
     * wählt man über einen passenden Parameter aus.
     *
     * @param rasse Rasse von der man Wesen erzeugen möchte
     * @param geld  Das Geld, das man investieren möchte.
     * @return Array mit den Wesen, das erste Element ist immer der Anführer.
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

        // ANFÜHRER DER RASSE ERSTELLEN

        // Überprüfen, um welche konkrete Rasse es sich handelt
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

        // WEITERE WESEN DER RASSE ERSTELLEN

        if (restMoney < rasse.getPrice()) {
            return playerSquad.wesenarray;
        }

        int amountRace = restMoney / rasse.getPrice(); // 700/150 = 4
        restMoney = restMoney - (amountRace * rasse.getPrice()); // 700 - (4*150) = 100
        playerSquad.setRestMoney(restMoney);

        // Restliche Wesen kaufen
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
     * Ermittelt den Index des letzten nicht-null-Elements im Array.
     *
     * @param playerSquadArray Das Array, in dem nach dem letzten Index gesucht werden soll.
     * @return Der Index des letzten nicht-null-Elements.
     */

    public static int getLastIndex(Wesen[] playerSquadArray) {
        int lastIndex = 0; // Initialisiere den Index

        // Durchlaufe das Array, um den Index des letzten nicht-null-Elements zu finden
        for (int i = 0; i < playerSquadArray.length; i++) {
            if (playerSquadArray[i] == null) {
                lastIndex = i; // Aktualisiere den Index des letzten nicht-null-Elements
                return lastIndex;
            }
        }
        return lastIndex;
    }

}
