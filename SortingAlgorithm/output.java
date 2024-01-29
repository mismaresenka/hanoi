package SortingAlgorithm;

import java.util.Scanner;

public class output {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println(
                "Bubble Sort[1], Exchange Sort[2], Selection Sort[3], Insertion Sort[4], Quick Sort[5], Merge Sort[6], and Bucket Sort[7].");
        int choice = input.nextInt();

        if (choice == 1) {

            bubbleSort sorter = new bubbleSort();

            // Call the inputData method to populate the 'storedData' ArrayList
            sorter.inputData();

            // Print unsorted data
            sorter.printUnsortedData();

            // Call the bubbleStart method to sort the data
            sorter.bubbleStart();

            // Print sorted data
            sorter.printSortData();
        } else {
            System.out.println("not available");
        }

    }
}