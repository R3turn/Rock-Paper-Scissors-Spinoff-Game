/*
* Name: Chris Tuncap
* Class: CS 2070, 08
* Date: February, 25 2018
* Description: This is a Java console game called Superman - Chuck Norris - Rock Game.
* Similar to the game rock, paper, scissor. Player one will play against the cpu (random number generator)
* for as many games as they wish. A scoreboard is implemented to keep track of the score after every game. 
 */
package christuncapassignment9;

import java.util.Random;
import java.util.Scanner;

public class ChrisTuncapAssignment9 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String response = null;
        Random rng = new Random();
        int[] scoreArray = {0, 0,0};
        greetTheUser();
        displayTheRules();

        do {
            int cpuChoice = getCPUChoice(rng);
            displayTheItemChoices();
            int choice = getUserChoices(keyboard);
            displayTheComputerChoice(cpuChoice);
            displayWhoWon(choice, cpuChoice, scoreArray);
            displayScoreboard(scoreArray);

            response = askUserIfTheyWouldLikeToPlayAgain(keyboard);

        } while ("yes".equals(response.toLowerCase()));

        displayClosing();
    }

    private static void displayScoreboard(int[] scoreArray) {
        System.out.println("\t\tScoreboard");
        System.out.println("Player: " + scoreArray[0] + "\tComputer: " + scoreArray[1] + "\tDraw: " + scoreArray[2]);
    }

    private static void displayClosing() {
        System.out.println("\t\tThanks for playing!");
    }

    private static String askUserIfTheyWouldLikeToPlayAgain(Scanner keyboard) {
        keyboard.nextLine();
        System.out.println("\nShould we play again: [YES] ");
        String userResponse = null;
        userResponse = keyboard.nextLine();
        return userResponse;
    }

    private static void displayWhoWon(int choice, int cpuChoice, int [] scoreArray) {
        if (choice == 1 && cpuChoice == 2 || choice == 2 && cpuChoice == 3 || choice == 3 && cpuChoice == 1) {
            System.out.println("You won!");
            scoreArray[0] += 1;
        } else if (choice == cpuChoice) {
            System.out.println("Draw!");
             scoreArray[2] += 1;
        } else {
            System.out.println("Computer won!");
             scoreArray[1] += 1;
        }
    }

    private static void displayTheComputerChoice(int cpuChoice) {
        if (cpuChoice == 1) {
            System.out.println("The computer picked Superman.");
        } else if (cpuChoice == 2) {
            System.out.println("The computer picked Chuck Norris.");
        } else {
            System.out.println("The computer picked Rock.");
        }
    }

    private static int getCPUChoice(Random rng) {
        return rng.nextInt(3) + 1;
    }

    private static int getUserChoices(Scanner keyboard) {
        return keyboard.nextInt();
    }

    private static void displayTheItemChoices() {
        System.out.println("Let's play! Enter a guess: ");
        System.out.println("1: Superman");
        System.out.println("2: Chuck Norris");
        System.out.println("3: Rock");
    }

    private static void displayTheRules() {
        System.out.println("\t\tGAME RULES");
        System.out.println("\t1. Superman beats Chuck Norris");
        System.out.println("\t2. Chuck Norris beats Rock");
        System.out.println("\t3. Rock beats Superman");
        System.out.println("\t4. User will forfeit their chance of\n\t   winning if choice is outside the range of 1 - 3.\n");
    }

    private static void greetTheUser() {
        System.out.println("Welcome to Chris Tuncap's Superman - Chuck Norris - Rock Game.\n");
    }

}
