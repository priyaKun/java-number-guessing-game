import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = args.length > 0
                ? new Random(Long.parseLong(args[0]))
                : new Random();

        System.out.println("=== Number Guessing Game ===");

        String choice;

        do {
            int secret = random.nextInt(100) + 1;
            playRound(scanner, secret);

            System.out.print("Play again? (y/n): ");
            choice = scanner.nextLine().trim();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    static void playRound(Scanner scanner, int secret) {
        int attempts = 0;
        boolean won = false;

        System.out.println();
        System.out.println("I am thinking of a number from 1 to 100.");
        System.out.println("You have 7 attempts.");

        while (attempts < 7 && !won) {
            System.out.print("Your guess: ");

            int guess = Integer.parseInt(scanner.nextLine().trim());

            if (guess < 1 || guess > 100) {
                System.out.println(
                        "Please guess a number from 1 to 100."
                );
                continue;
            }

            attempts++;
            won = checkGuess(guess, secret);

            if (won) {
                System.out.println(" Attempts used: " + attempts);
            }
        }

        if (!won) {
            System.out.println(
                    "Out of attempts. The number was " + secret + "."
            );
        }

    }

    static boolean checkGuess(int guess, int secret) {
        if (guess > secret) {
            System.out.println("Too high!");
            return false;
        }

        if (guess < secret) {
            System.out.println("Too low!");
            return false;
        }

        System.out.print("Correct!");
        return true;
    }
}