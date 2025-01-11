import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Hi! What is your name? ");
        String name = scanner.nextLine();

        int userScore = 0;
        int computerScore = 0;
        String[] choices = {"rock", "paper", "scissor"};

        while (true) {
            System.out.println("Please select Rock/Paper/Scissor or Q to Quit: ");
            String userSelection = scanner.nextLine().toLowerCase();

            if (userSelection.equals("q")) {
                break;
            }

            boolean validChoice = false;
            for (String choice : choices) {
                if (choice.equals(userSelection)) {
                    validChoice = true;
                    break;
                }
            }

            if (!validChoice) {
                System.out.println("Invalid Input");
                continue;
            }

            String computerSelection = choices[random.nextInt(3)];
            System.out.println("Computer chose " + computerSelection + ".");

            if (userSelection.equals("rock") && computerSelection.equals("scissor") ||
                userSelection.equals("paper") && computerSelection.equals("rock") ||
                userSelection.equals("scissor") && computerSelection.equals("paper")) {
                System.out.println("You Win!");
                userScore++;
            } else if (userSelection.equals(computerSelection)) {
                System.out.println("Draw");
            } else {
                System.out.println("You Lost!");
                computerScore++;
            }
        }

        System.out.println("You won " + userScore + " times.");
        System.out.println("Computer won " + computerScore + " times.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
