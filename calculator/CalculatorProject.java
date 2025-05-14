package calculator;
import java.util.Scanner;

public class CalculatorProject {

    static void add(double num1, double num2) {

        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
    }

    static void multiply(double num1, double num2) {

        System.out.println("The product of " + num1 + " and " + num2 + " is: " + (num1 * num2));
    }

    static void subtract(double num1, double num2) {

        System.out.println("The difference between " + num1 + " and " + num2 + " is: " + (num1 - num2));
    }

    static void divide(double num1, double num2) {

        if (num2 == 0) {
            System.out.println("Can't divide by zero");
            return;
        }

        System.out.println("The division of " + num1 + " and " + num2 + " is: " + (num1 / num2));
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first value: ");

        String  val1 = sc.nextLine();

        double parseValue1 = Double.parseDouble(val1);

        System.out.println("Enter the Second value: ");

        String val2 = sc.nextLine();

        double parseValue2 = Double.parseDouble(val2);

        System.out.println("Enter the operation [*,-,+,/]");
        String oper = sc.next();
        sc.close();

        switch (oper) {
            case "*":
                multiply(parseValue1, parseValue2);
                break;

            case "+":
                add(parseValue1, parseValue2);
                break;
                
            case "-":
                subtract(parseValue1, parseValue2);
                break;
                
            case "/":

                
                divide(parseValue1, parseValue2);
                break;
        
            default:
            System.out.println("The operation was invalid");
                break;
        }
    }

}