import java.util.Random;
import java.util.Scanner;

class Tracker {

    private int numberOfAttempt;
    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }

    public void setNumberOfAttempt(int numberOfAttempt) {
        this.numberOfAttempt = numberOfAttempt;
    }

    private int numberOfTries;

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public Tracker(int triesValue, int attemptValue) {

        this.numberOfTries = triesValue;
        this.numberOfAttempt = attemptValue;
    }
}

public class GuessTheNumber {

    static int randomValue() {
        Random rnd = new Random();
        return rnd.nextInt(2);
    }

    static int userInput(Scanner sc) {
        int guess = 0;
        System.out.println("Enter your guess: ");
        try {
            guess = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.printf("Invalid guess value: %s", e);
            System.exit(0);
        }
        return guess;

    }

    static int continueSession(Scanner sc) {
        System.out.println("Do you wish to continue: [Y/n]");
        String response = sc.next();
        if (response == "Y") {
            return GuessTheNumber.userInput(sc);
        } else {
            return 0;
        }

    }

    static void feedBack(int userValue, int compValue) {

        if ((compValue - userValue) < 10 && (compValue - userValue) != 0) {
            System.out.println("Your value was too HIGH.");
            System.out.printf("userGuess: %s\ncompGuess: %S\n", userValue, compValue);
        } else if ((compValue - userValue) > 10) {
            System.out.println("Your value was too LOW");
            System.out.printf("userGuess: %s\ncompGuess: %S\n", userValue, compValue);

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tracker tracker = new Tracker(0, 0);
        System.out.println("Welcome to my Guessing Game");
        System.out.printf("Difficulty Level: \n\t 1. Easy \n\t 2. Medium \n\t 3. Hard\n\n");

        System.out.println("Enter your Difficulty Level Number: ");
        String dL = sc.nextLine();

        switch (dL) {
            case "3": {
                tracker.setNumberOfTries(5);
                int count = tracker.getNumberOfAttempt();


                while (tracker.getNumberOfTries() > 0) {

                    int userVal = userInput(sc);
                    int rndVal = randomValue();
                    count++;

                    if (userVal == rndVal) {
                        System.out.println("You won. Congratulations!");
                        System.out.println("Number of Attempts: " + count);
                        return;
                    } else {
                        GuessTheNumber.feedBack(userVal, rndVal);
                    }
                    int tries = tracker.getNumberOfTries();
                    tracker.setNumberOfTries(tries - 1);
                    if (tracker.getNumberOfTries() == 0) {
                        System.out.println("Game Over");
                        System.out.println("Number of Attempts: " + 5);
                        tracker.setNumberOfTries(0);
                        break;
                    }
                    System.out.printf("You still have %d/5 Trials\n", tries - 1);

                }

            }
                break;

            case "2": {
                tracker.setNumberOfTries(10);
                int count = tracker.getNumberOfAttempt();

                while (tracker.getNumberOfTries() > 0) {

                    int userVal = userInput(sc);
                    int rndVal = randomValue();
                    count++;

                    if (userVal == rndVal) {
                        System.out.println("You won. Congratulations!");
                        System.out.println("Number of Attempts: " + count);
                        return;
                    } else {
                        GuessTheNumber.feedBack(userVal, rndVal);
                    }
                    int tries = tracker.getNumberOfTries();
                    tracker.setNumberOfTries(tries - 1);
                    if (tracker.getNumberOfTries() == 0) {
                        System.out.println("Game Over");
                        System.out.println("Number of Attempts: " + 10);
                        tracker.setNumberOfTries(0);
                        break;
                    }
                    System.out.printf("You still have %d/10 Trials\n", tries - 1);
                }
            }

                break;

            case "1": {
                int count = 0;
                while (true) {

                    int userVal = userInput(sc);
                    int rndVal = randomValue();
                    count++;
                    if (userVal == rndVal) {
                        System.out.println("You won. Congratulations!");
                        System.out.println("Number of Attempts: " + count);
                        return;
                    } else {
                        GuessTheNumber.feedBack(userVal, rndVal);
                    }
                }
            }

            default:
                System.out.println("Exiting...");
                System.out.println("Invalid Input");
                break;
        }

    }
}
