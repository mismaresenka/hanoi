package test;

import java.util.Scanner;

public class InfiniteLoopExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number (or type 'exit' to stop): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the loop.");
                break; // Break out of the infinite loop
            }

            // Process the input or perform some action
            try {
                int number = Integer.parseInt(input);
                System.out.println("You entered: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'exit'.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
