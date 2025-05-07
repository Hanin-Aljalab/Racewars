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
 * The GameController class manages the Racewars game and controls
 * the game flow and interaction with the players.
 */

public final class GameController {


    /**
     * Entry point of the program.
     *
     * @param args Command-line arguments.
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
     * Prepares the game by collecting player input and race selection.
     *
     * @param teamNumber The number of the team (1 or 2).
     * @param team       The player's squad.
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

        // First race selection
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

        // Investment for first race
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

        // Second race selection
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

        // Investment for second race
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
     * Returns a race instance based on the provided name.
     *
     * @param race The name of the race.
     * @return The corresponding race instance.
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
     * Randomly selects a creature from the opposing squad.
     *
     * @param team The opposing squad.
     * @return An array containing the selected creature and its index.
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
     * Checks which team has won.
     *
     * @param teamOne The first team.
     * @param teamTwo The second team.
     * @return The winning team number (1 for team 1, 2 for team 2, 0 for draw).
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
     * Runs the game until one team is eliminated.
     *
     * @param teamOne The first team.
     * @param teamTwo The second team.
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
     * Executes one round of the game where each creature in teamOne fights
     * a randomly selected creature from teamTwo.
     * @param teamOne     The first team.
     * @param teamTwo     The second team.
     * @param roundNumber The round number.
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

