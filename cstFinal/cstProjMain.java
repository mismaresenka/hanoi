package cstFinal;

import java.util.Scanner;

public class cstProjMain {

    public static void main(String[] args) {
        cstProjMethods start = new cstProjMethods();
        Scanner choice = new Scanner(System.in);
        System.out
                .println(
                        "[1] Intraceable Problem\n[2] Finite Automata\n[3] Turing Machine\n[4] Chomsky Normal Form\n[5] Context-Free Grammar\n[6] Greibach Normal Form\n[7] PDA\n[8] Regular Expression\n[9] Tower of Hanoi");
        int input = choice.nextInt();
        switch (input) {
            case 1:
                // Sample distance matrix for 3 cities
                int[][] distances = {
                        { 0, 10, 15 },
                        { 10, 0, 20 },
                        { 15, 20, 0 }
                };
                start.initialize(distances);
                start.IP();
                System.out.println("Shortest Distance: " + start.shortestDistance);
                System.out.print("Best Route: ");
                for (int city : start.bestRoute) {
                    System.out.print(city + " ");
                }
                break;
            case 2:
                start.FA();
                break;
            case 3:
                start.TM();
                break;
            case 4:
                start.CNF();
            case 5:
                start.CFG();
            case 6:
                start.GNF();
            case 7:
                start.PDA();
            case 8:
                start.RE();
            case 9:
                start.TOH();
            default:
                break;
        }
    }
}
