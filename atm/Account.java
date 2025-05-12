package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private double balance;
    private String pin;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    static void deposit(Account acc, String pin, double amt) {

        if (acc.getPin().equals(pin)) {
            acc.setBalance(acc.getBalance() + amt);
            System.out.printf("%dFCFA was deposited successfully", amt);
        } else {
            System.out.println("Invalid Credentials...");
        }
    }

    static void withdraw(Account acc, String pin, double amt) {
        if (acc.getBalance() < amt) {
            System.out.println("Insufficient Funds\nWithdrawal Failed");
            return;
        }
        if (acc.getPin().equals(pin)) {
            acc.setBalance(acc.getBalance() - amt);
            System.out.printf("%.2f FCFA was withdrawn successfully%n", amt);
        } else {
            System.out.println("Invalid Credentials...");
        }
    }

    static Account findAccount(List<Account> accounts, String pin) {

        for (Account acc : accounts) {
            if (acc.getPin().equals(pin)) {
                return acc;
            }
        }

        return null;
    }

    public Account(double initialDeposit, String accPIN) {
        this.balance = initialDeposit;
        this.pin = accPIN;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Simulator..");
        List<Account> accountList = new ArrayList<>();

        while (true) {

            System.out.printf(
                    "Avalaible Operations\n\t1. Create account\n\t2. Deposit \n\t3. Check Balance\n\t4. Withdraw\n\t5. Exit\n\n");

            System.out.println("What Operation do you want to perform ");
            int operation = -1;
            try {
                operation = Integer.parseInt(sc.nextLine());
                if (operation < 1 || operation > 5) {
                    System.out.println("Invalid Option. Choose from 1 to 5 only.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (operation) {
                case 1: {
                    System.out.println("Initializing account creation...");

                    System.out.println("Enter the Initial account Deposit");
                    double accDeposit = 0.0;
                    try {
                        accDeposit = Double.parseDouble(sc.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount to deposit");
                        break;
                    }

                    System.out.println("Enter the account PIN: ");

                    String accPin = sc.nextLine();

                    Account acc = new Account(accDeposit, accPin);

                    accountList.add(acc);
                    System.out.printf("Account created successfully\n");
                }
                    break;

                case 2: {
                    System.out.println("Initializing Deposit...");
                    System.out.println("Enter the amount to deposit");

                    double amt = 0.0;
                    try {
                        amt = Double.parseDouble(sc.nextLine());
                        if (amt <= 0) {
                            System.out.println("Amount must be greate than 0FCFA");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount to deposit");
                        break;
                    }
                    int tries = 0;
                    String pin;
                    Account foundAccount;
                    while (tries < 3) {
                        System.out.println("Enter the account pin: ");
                        pin = sc.nextLine();
                        foundAccount = Account.findAccount(accountList, pin);
                        if (foundAccount != null) {
                            Account.deposit(foundAccount, pin, amt);
                            break;
                        }
                        System.out.println("Incorrect PIN\nTry Again");
                        tries++;
                    }
                    if (tries == 3) {
                        System.out.println("Account not found");
                    }
                }

                    break;
                case 3: {
                    System.out.println("Getting account details...");
                    int tries = 0;
                    String pin;
                    Account foundAccount;
                    while (tries < 3) {
                        System.out.println("Enter the account pin: ");
                        pin = sc.nextLine();
                        foundAccount = Account.findAccount(accountList, pin);
                        if (foundAccount != null) {
                            System.out.printf("Account Balance: %.2fFCFA\n", foundAccount.getBalance());
                            break;
                        }
                        System.out.println("Incorrect PIN\nTry Again");
                        tries++;
                    }
                    if (tries == 3) {
                        System.out.println("Account not found");
                    }
                }

                    break;

                case 4: {
                    System.out.println("Initializing withdrawal...");
                    System.out.println("Enter the amount to withdraw");

                    double amt = 0.0;
                    try {
                        amt = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount to withdraw");
                        break;
                    }
                    int tries = 0;
                    String pin;
                    Account foundAccount;
                    while (tries < 3) {
                        System.out.println("Enter the account pin: ");
                        pin = sc.nextLine();
                        foundAccount = Account.findAccount(accountList, pin);
                        if (foundAccount != null) {
                            Account.withdraw(foundAccount, pin, amt);
                            break;
                        }
                        System.out.println("Incorrect PIN\nTry Again");
                        tries++;
                    }

                    if (tries == 3) {
                        System.out.println("Account not found");
                    }
                }
                    break;

                case 5: {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.out.printf("Option not found\nEnter a valid option\n");
                    break;
            }
        }
    }
}
