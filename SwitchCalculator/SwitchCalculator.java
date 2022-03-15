package SwitchCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        BigDecimal firstNum, secondNum, answer;
        char userSelected;

        var in = new Scanner(System.in);

        do {

            // Show menu
            CalculatorMenu();
            userSelected = in.next().charAt(0);

            // User wants to exit
            if (Character.toUpperCase(userSelected) == 'E') {
                break;
            }

            switch (userSelected) {
                case 'A', 'a':

                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);

                    answer = firstNum.add(secondNum);
                    System.out.println("First number + Second number = " + answer);

                    break;
                case 'S', 's':

                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);

                    answer = firstNum.subtract(secondNum);
                    System.out.println("First number - Second number = " + answer);

                    break;

                case 'M', 'm':

                    System.out.println("Enter first number: ");
                    firstNum = getDecimalInput(in);
                    System.out.println("Enter second number: ");
                    secondNum = getDecimalInput(in);

                    answer = firstNum.multiply(secondNum);
                    System.out.println("First number * Second number = " + answer);

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
                        if (secondNum.intValue() == 0) {
                            System.out.println("Error: " + e.getMessage());
                        } else {
                            if (e.getMessage().contains(
                                    "Non-terminating decimal expansion; no exact representable decimal result")) {
                                var ans = firstNum.doubleValue() / secondNum.doubleValue();
                                System.out.println("Beware! Error of precision ");
                                System.out.println("First number / Second number = " + ans);
                            }
                            // System.out.println("Error: " + e.getMessage());
                        }
                    }

                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
            }

            // try {
            // System.out.wait((long) 500.0);
            // } catch (InterruptedException e) {
            // // e.printStackTrace();
            // }
            // System.out.println("\n\n");
        } while (userSelected != 'e' || userSelected != 'E');

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
        BigDecimal num = null;
        var isInputValid = false;
        do {
            // var df = new DecimalFormat();
            // var symbols = new DecimalFormatSymbols();
            // symbols.setDecimalSeparator('.');
            // df.setDecimalFormatSymbols(symbols);
            try {
                num = in.nextBigDecimal();
                isInputValid = true;
            } catch (InputMismatchException e) {
                try {
                    // System.out.println(e.getMessage());
                    num = new BigDecimal(in.next().replace(',', '.'));
                    isInputValid = true;
                } catch (Exception exx) {
                    System.out.println(exx.getLocalizedMessage());
                }
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            if (!isInputValid) {
                System.out.println("Enter your input again please.");
            }
        } while (!isInputValid);
        return num;
    }
}
