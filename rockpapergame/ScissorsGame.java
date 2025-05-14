package rockpapergame;

import java.util.Scanner;


class UserRecord {
    private int score;
    private int attempts;
    private int fails;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFails() {
        return fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    void scoreInfo() {
        System.out.printf("UserRecord: \n\t- Score: %d\n\t- Attempts: %d\n\t- Fails: %d", getScore(), getAttempts(), getFails() );
    }

}

public class ScissorsGame {

    static String computerChoice() {

        int comp = (int) (Math.random() * 10);

        if (comp <= (1 / 3)) {
            return "rock";
        } else if (comp < (2 / 3) && (comp > (1 / 3))) {
            return "sciccors";
        } else {
            return "paper";
        }
    }

    static String userInput(Scanner sc) {

        System.out.println("Enter your Choice");
        String userInput = sc.nextLine().toLowerCase();

        switch (userInput) {
            case "1":
                return "rock";
            case "2":
                return "paper";
            case "3":
                return "scissors";
            default:
                System.out.println("Input not available");
                break;
        }
        return null;

    }

    public static void main(String[] args) {

        UserRecord score = new UserRecord();
        System.out.println("Welcome to Rock-Scissors Game");

        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.printf("\n\n1. Rock\n2. Paper\n3. Scissors\n\n");
            String userInput = userInput(sc);
            String compGuess = computerChoice();

            if (userInput == compGuess) {
                score.setScore(score.getScore() + 1);
                System.out.println("You won!");
                score.setAttempts(score.getAttempts() + 1);
                score.scoreInfo();
            } else {
                score.setFails(score.getFails() + 1);
                System.out.println("You missed");
                score.setAttempts(score.getAttempts() + 1);
                score.scoreInfo();
            }

        }

    }
}
