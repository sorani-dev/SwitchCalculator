package SwitchCalculator;

import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        double firstNum, secondNum, answer;
        char userSelected = 'c';

        CalculatorMenu();

        var in = new Scanner(System.in);
        userSelected = in.next().charAt(0);

        while (userSelected > 5 || userSelected == 'e') {
            switch (userSelected) {
                case 'A':
                case 'a':
                    System.out.println("Enter first number: ");
                    firstNum = in.nextDouble();
                    System.out.println("Enter second number: ");
                    secondNum = in.nextDouble();
                    answer = firstNum + secondNum;
                    System.out.println("First number + Second number = " + answer);
                    CalculatorMenu();

                    break;
                case 'S':
                case 's':
                    System.out.println("Enter first number: ");
                    firstNum = in.nextDouble();
                    System.out.println("Enter second number: ");
                    secondNum = in.nextDouble();
                    answer = firstNum - secondNum;
                    System.out.println("First number - Second number = " + answer);

                    CalculatorMenu();
                    break;

                case 'M':
                case 'm':
                    System.out.println("Enter first number: ");
                    firstNum = in.nextDouble();
                    System.out.println("Enter second number: ");
                    secondNum = in.nextDouble();
                    answer = firstNum * secondNum;
                    System.out.println("First number * Second number = " + answer);

                    CalculatorMenu();

                    break;

                case 'D':
                case 'd':
                    System.out.println("Enter first number: ");
                    firstNum = in.nextDouble();
                    System.out.println("Enter second number: ");
                    secondNum = in.nextDouble();
                    answer = firstNum / secondNum;
                    System.out.println("First number / Second number = " + answer);

                    CalculatorMenu();

                    break;

                case 'E':
                case 'e':
                    break;

                default:
                    System.out.println("Invalid Selection");

                    break;
            }
            if (userSelected == 'e' || userSelected == 'E') {
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
}
