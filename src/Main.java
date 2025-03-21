import java.util.Scanner;
import java.util.Random;



public class Main {
    public static boolean numGuess(int answer, int num1, int num2) {
        boolean correct = false;
        Scanner scanner = new Scanner(System.in);
        int k = 8;
        System.out.println("I'm thinking of a number between " + num2 + " and " + num1 + ".");
        while (k > 0) {
            System.out.println("Enter your guess:");
            int guess = scanner.nextInt();
            if (guess == answer) {
              correct = true;
              break;
            } else if (guess > answer) {
                k--;
                System.out.println("Too high! You have " + k + "guesses left.");
            } else {
                k--;
                System.out.println("Too low! You have " + k + "guesses left.");
            }
        }
        return correct;
    }


    public static void tryAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again?\n1. Yes\n2. No");
        int choice = scanner.nextInt();
        if (choice == 1) {
            main(null);
        } else {
            System.out.println("Goodbye!");
        }
    }

    public static int selCustomDifficulty(int num1, int num2) {
        System.out.println("Generating numbers...");
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        return rand.nextInt(num1 - num2) + num2;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!\nEnter your difficulty:\n1.Default(1-100)\n2.Custom\n3.Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1){
            int answer = random.nextInt(101);
            boolean correct = numGuess(answer, 1, 100);
            if (correct) {
                System.out.println("Correct!\nYou Win!");
                tryAgain();
            } else {
                System.out.println("You ran out of tries.\nYou Lose!");
                tryAgain();
            }
        } else if (choice == 2){
            System.out.println("Custom Difficulty");
            System.out.print("Enter the max. number to be generated:");
            int num1 = scanner.nextInt();
            System.out.println();
            if (num1 > 0){
                System.out.print("Enter the min. number to be generated:");
                int num2 = scanner.nextInt();
                if (num2 > 0){
                    int answer = selCustomDifficulty(num1, num2);
                    boolean correct = numGuess(answer, num1, num2);
                    if (correct) {
                        System.out.println("Correct!\nYou Win!");
                        tryAgain();
                    } else {
                        System.out.println("You ran out of tries.\nYou Lose!");
                        tryAgain();
                    }
                } else {
                    System.out.println("Number must be positive!\nRestarting...");
                    main(null);
                }
            } else {
                System.out.println("Number must be positive!\nRestarting...");
                main(null);


            }
        } else if (choice == 3) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid input!\nRestarting...");
            main(null);
        }
    }
}