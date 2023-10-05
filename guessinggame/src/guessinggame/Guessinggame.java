
package guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Guessinggame {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int score = 0;

        System.out.println("\nWelcome to the Number Guessing Game!");
        System.out.println("\nLet's begin the guessing game!");

        while (attempts < 3) {
            System.out.println("\nGuess the secret number: ");
            int guess = inputScanner.nextInt();

            if (guess > secretNumber) {
                System.out.println("\nSorry, the secret number is lower than " + guess);
            } else if (guess < secretNumber) {
                System.out.println("\nSorry, the secret number is higher than " + guess);
            } else {
                score += 100 - (25 * attempts);
                System.out.println("\nCongratulations! You guessed it right!");
                System.out.println("\nThe secret number is " + guess);
                System.out.println("\nYour score: " + score);
                int playAgainChoice = askToPlayAgain(inputScanner);

                if (playAgainChoice == 1) {
                    secretNumber = random.nextInt(100) + 1;
                    attempts = 0;
                } else {
                    System.out.println("\nThank you! Play again later...");
                    break;
                }
            }
            attempts++;
        }

        if (attempts == 3) {
            score = 0;
            System.out.println("\nYou've used up all your chances! Apologies.");
            System.out.println("\nYour final score: " + score);
            System.out.println("\nThe secret number you missed was " + secretNumber);
            int playAgainChoice = askToPlayAgain(inputScanner);

            if (playAgainChoice == 1) {
                playGame();
            } else {
                System.out.println("Thank you! Play again later...");
            }
        }
        inputScanner.close();
    }

    public static int askToPlayAgain(Scanner scanner) {
        System.out.println("\nDo you want to play the game again? Press 1 for Yes, and 2 for No.");
        return scanner.nextInt();
    }
}

