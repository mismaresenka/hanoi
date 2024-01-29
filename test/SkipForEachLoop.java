package test;

import java.util.ArrayList;
import java.util.List;

public class SkipForEachLoop {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        processNumbers(numbers);
    }

    private static void processNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            switch (number) {
                case 2:
                    // Skip the loop for number 2
                    return;
                case 4:
                    // Skip the loop for number 4
                    return;
                default:
                    // Process other numbers
                    System.out.println("Processing: " + number);
            }
        });
    }
}
