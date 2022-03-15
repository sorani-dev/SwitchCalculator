package SwitchCalculator;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        BigDecimal firstNum, secondNum, answer;
        char userSelected = 'c';

        CalculatorMenu();

        var in = new Scanner(System.in);
        userSelected = in.next().charAt(0);

        while (userSelected > 5 || userSelected == 'e') {
            switch (userSelected) {
                case 'A', 'a':
                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);
                    answer = firstNum.add(secondNum);
                    System.out.println("First number + Second number = " + answer);
                    CalculatorMenu();

                    break;
                case 'S', 's':
                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);
                    answer = firstNum.subtract(secondNum);
                    System.out.println("First number - Second number = " + answer);

                    CalculatorMenu();
                    break;

                case 'M', 'm':
                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);
                    answer = firstNum.multiply(secondNum);
                    System.out.println("First number * Second number = " + answer);

                    CalculatorMenu();

                    break;

                case 'D', 'd':
                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);
                    try {
                        answer = firstNum.divide(secondNum);
                        System.out.println("First number / Second number = " + answer);
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    CalculatorMenu();

                    break;

                case 'E', 'e':
                    break;

                default:
                    System.out.println("Invalid Selection");

                    break;
            }
            if (Character.toUpperCase(userSelected) == 'E') {
                break;
            }
            // try {
            // System.out.wait((long) 500.0);
            // } catch (InterruptedException e) {
            // // e.printStackTrace();
            // }
            // System.out.println("\n\n");
            userSelected = in.next().charAt(0);
        }
        in.close();

    }

    public static void CalculatorMenu() {
        System.out.println("+================================+");
        System.out.println("|  Welcome to Simple Calculator  |");
        System.out.println("|      Using Java Console        |");
        System.out.println("+================================+");

        String menuItems[] = { "A) Addition", "B) Substraction", "M) Multiplication", "D) Division", "E) Exit" };
        int options = menuItems.length;

        System.out.println("\t\tM E N U");
        System.out.println("+================================+\n");
        System.out.println("Select an option");

        for (int i = 0; i < options; i++) {
            System.out.println(menuItems[i] + "\n");
        }

        System.out.println("+================================+");
    }

    public static double getDoubleInput(Scanner in) {
        var num = 0.0;
        try {
            num = in.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            num = Double.parseDouble(in.next().replace(',', '.'));
        }
        return num;
    }

    public static BigDecimal getDecimalInput(Scanner in) {
        var num = new BigDecimal(0.0);
        // var df = new DecimalFormat();
        // var symbols = new DecimalFormatSymbols();
        // symbols.setDecimalSeparator('.');
        // df.setDecimalFormatSymbols(symbols);
        try {

            num = in.nextBigDecimal();
        } catch (InputMismatchException e) {
            // System.out.println(e.getMessage());
            num = new BigDecimal(in.next().replace(',', '.'));
        }
        return num;
    }
}
