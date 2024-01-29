package SortingAlgorithm;

import java.util.ArrayList;

public class bubbleSort extends abstractMethod {

    @Override
    public void bubbleStart() {
        ArrayList<Integer> data = storedData; // Access the 'storedData' ArrayList

        int n = data.size(); // Use 'data' instead of 'arr'

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1)); // Use 'set' method to update the value
                    data.set(j + 1, temp);
                }
            }
        }

    }

    public void printUnsortedData() {
        System.out.println("Unsorted data:");
        for (int num : storedData) {
            System.out.print(num + " ");
        }
    }

    public void printSortData() {
        System.out.println('\n' + "Sorted data:");
        for (int num : storedData) {
            System.out.print(num + " ");
        }
    }
}
