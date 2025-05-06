package pr2.vererbung.racewars.racewars.controller;


import java.util.Random;

import java.util.Scanner;


import pr2.vererbung.racewars.racewars.model.Mensch;

import pr2.vererbung.racewars.racewars.model.Nachtelf;

import pr2.vererbung.racewars.racewars.model.Ork;

import pr2.vererbung.racewars.racewars.model.Untote;

import pr2.vererbung.racewars.racewars.model.Rasse;

import pr2.vererbung.racewars.racewars.model.Wesen;

import pr2.vererbung.racewars.racewars.model.WesenFactory;

import pr2.vererbung.racewars.racewars.viewer.GameViewer;


/**
 * Die Klasse GameController verwaltet das Spiel Racewars und steuert den Ablauf
 * des Spiels sowie die Interaktion mit den Spielern.
 */

public final class GameController {


    /**
     * Einstiegspunkt in das Programm.
     * @param args Kommandozeilenargumente.
     */

    public static void main(String[] args) {

        GameController game = new GameController();

        Squad teamOne = new Squad();

        Squad teamTwo = new Squad();


        System.out.println("*** Willkommen beim Spiel Racewars ***");


        game.playerInput(1, teamOne);

        System.out.println("-----------------------------------------------");

        game.playerInput(2, teamTwo);


        game.runGame(teamOne, teamTwo);

    }


    /**
     * Vorbereitung vor dem Spiel, einschließlich Eingabe von Spielerinformationen
     * <p>
     * und Rassenauswahl.
     *
     * @param teamNumber Die Nummer des Teams (1 oder 2).
     * @param team       Das Squad des Spielers.
     */

    public void playerInput(int teamNumber, Squad team) {


        Scanner sc = new Scanner(System.in);


        String player_race;

        int player_money;

        int restMoney;


        System.out.print("SPIELER " + teamNumber + ": Bitte wählen Sie den Namen Ihres Squads: ");

        team.setSquadName(sc.nextLine());

        System.out.println();


        System.out.println("SPIELER " + teamNumber + ": Ihr Budget ist: " + team.MAX_INVEST);

        System.out.println();


        do {

            System.out.print("SPIELER " + teamNumber

                    + ": Bitte wählen Sie die 1. Rasse für Ihr Squad (Ork - Mensch - Nachtelf - Untote): ");

            player_race = sc.nextLine();


            if (!player_race.equals("Ork") && !player_race.equals("Mensch") && !player_race.equals("Nachtelf")

                    && !player_race.equals("Untote")) {

                System.out.println("Bitte wiederholen Sie Ihre Eingabe !");

            }

        } while (!player_race.equals("Ork") && !player_race.equals("Mensch") && !player_race.equals("Nachtelf")

                && !player_race.equals("Untote"));


        System.out.println();


        do {

            System.out.print("SPIELER " + teamNumber + ": Wie viel Geld möchten Sie in diese Rasse investieren? : ");

            player_money = sc.nextInt();


            // Consume newline left-over

            sc.nextLine();

            System.out.println();


            if (player_money > team.MAX_INVEST) {

                System.out.println("Ihr Investment übersteigt das Budget !");

            }

        } while (player_money > team.MAX_INVEST);


        Rasse chosenRace = getRasseByName(player_race);


        Wesen[] playerOneArrayWesen = WesenFactory.create(chosenRace, player_money, team);


        restMoney = team.MAX_INVEST - player_money + team.restMoney;


        System.out.println("SPIELER " + teamNumber + ": Ihr Budget ist: " + restMoney);

        System.out.println();


        do {

            System.out.print("SPIELER " + teamNumber

                    + ": Bitte wählen Sie die 2. Rasse für Ihr Squad (Ork - Mensch - Nachtelf - Untote): ");

            player_race = sc.nextLine();


            if (!player_race.equals("Ork") && !player_race.equals("Mensch") && !player_race.equals("Nachtelf")

                    && !player_race.equals("Untote")) {

                System.out.println("Bitte wiederholen Sie Ihre Eingabe !");

            }

        } while (!player_race.equals("Ork") && !player_race.equals("Mensch") && !player_race.equals("Nachtelf")

                && !player_race.equals("Untote"));


        System.out.println();


        do {

            System.out.print("SPIELER " + teamNumber + ": Wie viel Geld möchten Sie in diese Rasse investieren? : ");

            player_money = sc.nextInt();


            // Consume newline left-over

            sc.nextLine();

            System.out.println();


            if (player_money > restMoney) {

                System.out.println("Ihr Investment übersteigt das Budget !");

            }

        } while (player_money > restMoney);


        chosenRace = getRasseByName(player_race);


        playerOneArrayWesen = WesenFactory.create(chosenRace, player_money, team);


    }


    /**
     * Gibt eine Rasse entsprechend dem übergebenen Namen zurück.
     *
     * @param race Der Name der Rasse.
     * @return Die entsprechende Rasse-Instanz.
     */


    private Rasse getRasseByName(String race) {

        if (race.equals("Mensch")) {

            return new Mensch();

        }

        if (race.equals("Ork")) {

            return new Ork();

        }

        if (race.equals("Nachtelf")) {

            return new Nachtelf();

        }

        if (race.equals("Untote")) {

            return new Untote();

        }

        return null;

    }


    /**
     * Wählt zufällig ein Wesen aus dem gegnerischen Squad aus.
     *
     * @param team Das gegnerische Squad.
     * @return Ein Array, das das ausgewählte Wesen und seinen Index enthält.
     */


    private Object[] getRandomWesen(Squad team) {

        Random random = new Random();

        int randomIndex = random.nextInt(team.getSquadNumber());

        Object[] result = new Object[2];

        result[0] = team.wesenarray[randomIndex]; // Das Wesen

        result[1] = randomIndex; // Der Index


        while (result[0] == null) {

            randomIndex = random.nextInt(team.getSquadNumber());

            result[0] = team.wesenarray[randomIndex]; // Das Wesen

            result[1] = randomIndex; // Der Index

        }

        return result;

    }


    /**
     * Überprüft, welches Team gewonnen hat.
     *
     * @param teamOne Das erste Team.
     * @param teamTwo Das zweite Team.
     * @return Die Nummer des Gewinnerteams (1 für Team 1, 2 für Team 2, 0 für
     * <p>
     * Unentschieden).
     */


    public int checkWinner(Squad teamOne, Squad teamTwo) {

        // Überprüfen, welcher der beiden Squads mehr Mitglieder hat

        if (teamOne.getSquadNumber() > teamTwo.getSquadNumber()) {

            return 1;

        } else if (teamOne.getSquadNumber() < teamTwo.getSquadNumber()) {

            return 2;

        }

        return 0;

    }


    /**
     * Spielt das Spiel bis zum Ende.
     *
     * @param teamOne Das erste Team.
     * @param teamTwo Das zweite Team.
     */

    public void runGame(Squad teamOne, Squad teamTwo) {

        GameViewer gameViewer = new GameViewer();

        // Runde 1 bis 3 - Kampf starten

        int gameRoundCounter = 1;

        boolean emptySquad = false;

        do {


            if (teamOne.squadIsEmpty() || teamTwo.squadIsEmpty()) {

                emptySquad = true;

            } else {

                emptySquad = false;


                gameViewer.printGame(teamOne);

                System.out.println("-----------------");

                gameViewer.printGame(teamTwo);

                System.out.println("-----------------");


                gameRound(teamOne, teamTwo, gameRoundCounter);

                gameRound(teamTwo, teamOne, gameRoundCounter);


                gameRoundCounter++;

            }


        } while (!emptySquad);


        int winnerNumber = checkWinner(teamOne, teamTwo);

        System.out.println("-------SPIEL BEENDET-------");

        gameViewer.printWinner(winnerNumber, teamOne, teamTwo);


    }


    /**
     * Führt eine Runde des Spiels durch, in der jedes Wesen des ersten Teams gegen
     * <p>
     * ein zufällig ausgewähltes Wesen des zweiten Teams kämpft.
     *
     * @param teamOne     Das erste Team.
     * @param teamTwo     Das zweite Team.
     * @param roundNumber Die Nummer der aktuellen Runde.
     */


    public void gameRound(Squad teamOne, Squad teamTwo, int roundNumber) {

        System.out.println("-------RUNDE " + roundNumber + "-------");

        System.out.println("***Squad " + teamOne.getSquadName() + " vs Squad " + teamTwo.getSquadName());


        for (int i = 0; i < teamOne.getSquadNumber(); i++) {

            Object[] randomWesen = new Object[2];


            Wesen playerWesen = teamOne.wesenarray[i];

            String deadWesenHealth;


            if (teamTwo.getSquadNumber() <= 0) {

                continue;

            }

            randomWesen = getRandomWesen(teamTwo);

            Wesen enemyWesen = (Wesen) randomWesen[0];

            int enemyWesenIndex = (int) randomWesen[1];


            System.out.print(playerWesen.getName() + " [" + playerWesen.getHealthPoints() + " ❤️ | "

                    + playerWesen.getSchaden() + " 🗡️ | " + playerWesen.getArmor() * 100 + "% 🛡️]" + " ⚔️ "

                    + enemyWesen.getName() + " [" + enemyWesen.getHealthPoints() + " ❤️ | " + enemyWesen.getSchaden()

                    + " 🗡️ | " + enemyWesen.getArmor() * 100 + "% 🛡️] ----> ");


            double damage = playerWesen.attacke(enemyWesen);


            System.out.println("[" + damage + " SCHADEN]");


            if (!enemyWesen.isLebendig()) {

                teamOne.removeDeadCreature(teamTwo, enemyWesenIndex);

                deadWesenHealth = "💀💀💀";

            } else {

                deadWesenHealth = Double.toString(enemyWesen.getHealthPoints());

            }


            System.out.println("	-->	  " + playerWesen.getName() + " [" + playerWesen.getHealthPoints() + "] ⚔️ "

                    + enemyWesen.getName() + " [" + deadWesenHealth + "]");


        }

    }


}

