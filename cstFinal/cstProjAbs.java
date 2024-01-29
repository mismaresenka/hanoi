package cstFinal;

import java.util.ArrayList;
import java.util.Scanner;

abstract class cstProjAbs {

    protected static ArrayList<Integer> storedData = new ArrayList<>();
    protected static ArrayList<String> stringStoredData = new ArrayList<>();

    abstract void FA();

    abstract void PDA();

    abstract void REI();

    abstract void CNF();

    abstract void CFG();

    abstract void TM();

    abstract void IP();

    public static void print2DArray(String[][] table) {
        // Iterate through the 2D array and print its elements
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static void inputData() {
        Scanner scan = new Scanner(System.in);
        String input;
        while (true) {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            stringStoredData.add(input);
        }

        // Convert string data to int and store in storedData
        for (String num : stringStoredData) {
            int temp = Integer.parseInt(num);
            storedData.add(temp);
        }
    }

}
