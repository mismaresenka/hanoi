package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

abstract class abstractMethod implements interfaceMethod {

    protected ArrayList<Integer> storedData;

    public void inputData() {
        storedData = new ArrayList<>();
        String data = "";
        ArrayList<String> stringStoredData = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("(TYPE 'STOP' WHEN YOU'RE DONE)\nInput your data: ");

        while (!data.equalsIgnoreCase("stop")) {
            data = input.nextLine();
            if (!data.equalsIgnoreCase("stop")) {
                stringStoredData.add(data);
            }
        }

        System.out.println("OKAY");

        // for converting string to int
        for (String num : stringStoredData) {
            int temp = Integer.parseInt(num);
            storedData.add(temp);
        }

    }

}
