package cstFinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class cstProjMethods extends cstProjAbs {

    private Scanner choice;
    private String[][] table;
    private boolean stateA;
    private boolean stateB;
    private boolean stateC;
    private boolean acceptInput;
    private int[][] distances;
    private int numberOfCities;
    int[] bestRoute;
    int shortestDistance;

    cstProjMethods() {
        this.choice = new Scanner(System.in);

    }

    public void initialize(int[][] distances) {
        this.distances = distances;
        numberOfCities = distances.length;
        bestRoute = new int[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            bestRoute[i] = i;
        }
        shortestDistance = Integer.MAX_VALUE;
    }

    void FA() {
        // Prompt the user to choose between DFA and NDFA
        System.out.println("input (1) for DFA example\n      (2) for NDFA");
        int choices = choice.nextInt();
        
        switch (choices) {
            case 1:
                // DFA transition table
                table = new String[][] {
                    { "States", "Input 0", "Input 1" },
                    { "  a   ", "   a   ", "   b   " },
                    { "  b   ", "   c   ", "   a   " },
                    { "  c   ", "   b   ", "   c   " }
                };
                
                // Print information about the DFA
                System.out.println(
                    "Let a deterministic finite automaton be ->\n Set of states: {a,b,c}\n Set of symbols: {1,0}\n Initial State: {a}\n Set of Final State: {c}\n Transition Function: ");
                print2DArray(table);
                
                // Prompt user for input
                System.out.println("Please provide input: ");
                inputData();
                
                acceptInput = false;
                stateA = false;
                stateB = false;
                stateC = false;
    
                // Process the input for DFA
                for (int num : storedData) {
                    switch (num) {
                        case 1:
                            // Transition rules for input 1
                            if (stateA == false && stateB == false && stateC == false) {
                                stateB = true;
                                break;
                            } else if (stateB == true) {
                                stateB = false;
                                break;
                            } else if (stateC == true) {
                                break;
                            }
                        case 0:
                            // Transition rules for input 0
                            if (stateB == true) {
                                stateC = true;
                                acceptInput = true;
                                break;
                            } else if (stateA == false && stateB == false && stateC == false) {
                                break;
                            } else if (stateC == true) {
                                stateC = false;
                                acceptInput = false;
                                break;
                            }
                        default:
                            System.out.println("invalid input.");
                    }
                }
                // Output the result for DFA
                if (acceptInput == true) {
                    System.out.println("The string is accepted");
                } else {
                    System.out.println("The string is rejected");
                }
                break;
    
            case 2:
                // NDFA transition table
                table = new String[][] {
                    { "States", "Input 0", "Input 1", "Input 2" },
                    { "  A   ", "   -   ", "   B   ", "   C   " },
                    { "  B   ", " {A,C} ", "   C   ", "   -   " },
                    { "  C   ", "   -   ", "   -   ", "   -   " }
                };
                
                // Print information about the NDFA
                System.out.println(
                    "Let a Non-Deterministic finite automaton be ->\n Set of states: {A,B,C}\n Set of symbols: {0,1,2}\n Initial State: {A}\n Set of Final State: {A}\n Transition Function: ");
                print2DArray(table);
                
                // Prompt user for input
                System.out.println("Please provide input: ");
                inputData();
                
                acceptInput = false;
                stateA = false;
                stateB = false;
                stateC = false;
    
                // Process the input for NDFA
                for (int num : storedData) {
                    switch (num) {
                        case 0:
                            // Transition rules for input 0
                            if (stateA == false && stateB == false && stateC == false) {
                                acceptInput = true;
                            } else if (stateB == true) {
                                acceptInput = false;
                                System.out.println("Will you go stateA (Final State) [1] or stateC (Deadend) [2]?");
                                Scanner either = new Scanner(System.in);
                                int AorC = either.nextInt();
                                switch (AorC) {
                                    case 1:
                                        stateB = false;
                                        acceptInput = true;
                                        break;
                                    case 2:
                                        stateC = true;
                                        acceptInput = false;
                                        break;
                                }
                            } else if (stateC == true) {
                                acceptInput = false;
                            }
                            break;
    
                        case 1:
                            // Transition rules for input 1
                            if (stateA == false) {
                                stateB = true;
                                acceptInput = false;
                            } else if (stateC == true) {
                                acceptInput = false;
                            } else if (stateB == true) {
                                stateC = true;
                            }
                            break;
    
                        case 2:
                            // Transition rules for input 2
                            if (stateC == true) {
                                acceptInput = false;
                            } else if (stateA == false) {
                                stateC = true;
                                acceptInput = false;
                            }
                            break;
    
                        default:
                            break;
                    }
                }
                // Output the result for NDFA
                if (acceptInput == true) {
                    System.out.println("The string is accepted");
                } else {
                    System.out.println("The string is rejected");
                }
        }
    }
    


    void RE() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        if (isREAccepted(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }
    }

    private boolean isREAccepted(String input) {
        return input.matches("a+b+"); // Use regular expression matching
    }


    void TOH() {
        // Prompt the user to enter the number of disks
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int numberOfDisks = scanner.nextInt();
    
        // Display the initial message
        System.out.println("The steps to solve the Tower of Hanoi with " + numberOfDisks + " disks are:");
    
        // Call the recursive function to solve the Tower of Hanoi
        towerOfHanoi(numberOfDisks, 'A', 'C', 'B');
    }
    
    // Recursive function to solve the Tower of Hanoi
    private void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        // Base case: If there is only one disk, move it from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
    
        // Move (n-1) disks from source to auxiliary peg
        towerOfHanoi(n - 1, source, auxiliary, destination);
    
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
    
        // Move (n-1) disks from auxiliary to destination peg
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    

     void PDA() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        if (isREAccepted(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }
    }

    private boolean isAccepted(String input) {
        Stack<Character> stack = new Stack<>();
        stack.push('Z'); // 'Z' is the initial stack symbol

        for (char symbol : input.toCharArray()) {
            if (stack.isEmpty()) {
                return false; // If the stack is empty, reject the input
            }

            char topOfStack = stack.pop();

            if (symbol == 'a' && topOfStack == 'Z') {
                stack.push('a'); // Push 'a' onto the stack for each 'a' in the input
            } else if (symbol == 'b' && topOfStack == 'a') {
                // Pop 'a' from the stack for each 'b' in the input
            } else {
                return false; // Reject if the input doesn't match the PDA rules
            }
        }

        return stack.isEmpty(); // Accept if the stack is empty after processing the input
    }

    void REI() {

    }

    void GNF() {
        // Example grammar for GNF
        Map<String, List<String>> gnfGrammar = new HashMap<>();
        gnfGrammar.put("S", Arrays.asList("aA", "bB"));
        gnfGrammar.put("A", Arrays.asList("aA", "bB", "ε"));
        gnfGrammar.put("B", Arrays.asList("aS", "bS", "ε"));

        displayGrammarInfo(gnfGrammar, "GNF Grammar");

        boolean isGNF = verifyGNF(gnfGrammar);
        System.out.println("Is the GNF grammar in Greibach Normal Form? " + isGNF);
    }

    private void displayGrammarInfo(Map<String, List<String>> grammar, String grammarType) {
        System.out.println(grammarType + ":");
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            List<String> productions = entry.getValue();
            for (String production : productions) {
                System.out.print(production + " | ");
            }
            System.out.println();
        }
    }

    private boolean verifyGNF(Map<String, List<String>> grammar) {
        // GNF verification logic
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            List<String> productions = entry.getValue();
            for (String production : productions) {
                if (!production.isEmpty() && !Character.isUpperCase(production.charAt(0))) {
                    System.out.println("Error: GNF production must start with a non-terminal symbol.");
                    return false;
                }
            }
        }

        return true;
    }

    void CNF() {
        // Example grammar
        Map<String, List<String>> grammar = new HashMap<>();
        grammar.put("S", Arrays.asList("AB", "BC", "a"));
        grammar.put("A", Arrays.asList("BA", "a"));
        grammar.put("B", Arrays.asList("CC", "b"));
        grammar.put("C", Arrays.asList("AB", "a"));
    
        // Display the original grammar
        displayCNFGrammar(grammar);
    
        // Verify if the grammar is in Chomsky Normal Form (CNF)
        boolean isCNF = verifyCNF(grammar);
        System.out.println("Is the grammar in Chomsky Normal Form? " + isCNF);
    }
    
    // Display the grammar
    private void displayCNFGrammar(Map<String, List<String>> grammar) {
        System.out.println("Grammar:");
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            List<String> productions = entry.getValue();
            for (String production : productions) {
                System.out.print(production + " | ");
            }
            System.out.println();
        }
    }
    
    // Verify if the grammar is in Chomsky Normal Form (CNF)
    private boolean verifyCNF(Map<String, List<String>> grammar) {
        // Check for epsilon and unit productions
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();
    
            if (productions.contains("")) {
                System.out.println("Grammar contains epsilon production.");
                return false;
            }
    
            for (String production : productions) {
                if (production.length() == 1 && Character.isUpperCase(production.charAt(0))) {
                    System.out.println("Grammar contains unit production: " + nonTerminal + " -> " + production);
                    return false;
                }
            }
        }
    
        // Check for Chomsky Normal Form conditions
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();
    
            for (String production : productions) {
                if (production.length() > 2) {
                    System.out.println(
                            "Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                    return false;
                }
    
                if (production.length() == 2) {
                    if (!(Character.isUpperCase(production.charAt(0)) && Character.isUpperCase(production.charAt(1)))) {
                        System.out.println(
                                "Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                        return false;
                    }
                }
    
                if (production.length() == 1) {
                    if (!Character.isLowerCase(production.charAt(0))) {
                        System.out.println(
                                "Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                        return false;
                    }
                }
            }
        }
    
        // If all conditions are met, the grammar is in CNF
        return true;
    }
    

    void CFG() {
        // Example grammar
        Map<String, List<String>> grammarCFG = new HashMap<>();
        grammarCFG.put("S", Arrays.asList("AB", "BC", "a"));
        grammarCFG.put("A", Arrays.asList("BA", "a"));
        grammarCFG.put("B", Arrays.asList("CC", "b"));
        grammarCFG.put("C", Arrays.asList("AB", "a"));

        displayGrammarInfo(grammarCFG);

        boolean isCNF = verifyChomskyNormalForm(grammarCFG);
        System.out.println("Is the grammar in Chomsky Normal Form? " + isCNF);

        boolean isValidCFG = verifyContextFreeGrammar(grammarCFG);
        System.out.println("Is the grammar a valid context-free grammar? " + isValidCFG);
    }
    
    private void displayGrammarInfo(Map<String, List<String>> grammarCFG) {
        System.out.println("Grammar:");
        for (Map.Entry<String, List<String>> entry : grammarCFG.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            List<String> productions = entry.getValue();
            for (String production : productions) {
                System.out.print(production + " | ");
            }
            System.out.println();
        }
    }

    private boolean verifyChomskyNormalForm(Map<String, List<String>> grammarCFG) {
        // Check for epsilon and unit productions
        for (Map.Entry<String, List<String>> entry : grammarCFG.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();

            if (productions.contains("")) {
                System.out.println("Grammar contains epsilon production.");
                return false;
            }

            for (String production : productions) {
                if (production.length() == 1 && Character.isUpperCase(production.charAt(0))) {
                    System.out.println("Grammar contains unit production: " + nonTerminal + " -> " + production);
                    return false;
                }
            }
        }

        // Check for Chomsky Normal Form conditions
        for (Map.Entry<String, List<String>> entry : grammarCFG.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();

            for (String production : productions) {
                if (production.length() > 2) {
                    System.out.println("Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                    return false;
                }

                if (production.length() == 2) {
                    if (!(Character.isUpperCase(production.charAt(0)) && Character.isUpperCase(production.charAt(1)))) {
                        System.out.println("Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                        return false;
                    }
                }

                if (production.length() == 1) {
                    if (!Character.isLowerCase(production.charAt(0))) {
                        System.out.println("Grammar does not satisfy the CNF condition: " + nonTerminal + " -> " + production);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean verifyContextFreeGrammar(Map<String, List<String>> grammarCFG) {
        // Check for epsilon productions
        for (Map.Entry<String, List<String>> entry : grammarCFG.entrySet()) {
            List<String> productions = entry.getValue();
            for (String production : productions) {
                if (production.equals("ε")) {
                    System.out.println("Grammar contains epsilon production.");
                    return false;
                }
            }
        }

        // Check for left recursion
        for (Map.Entry<String, List<String>> entry : grammarCFG.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();
            for (String production : productions) {
                if (production.startsWith(nonTerminal)) {
                    System.out.println("Grammar contains left recursion in production: " + nonTerminal + " -> " + production);
                    return false;
                }
            }
        }

        return true;
    }

    void TM() {
        // Scanner to read user input
        Scanner inputs = new Scanner(System.in);
        // ArrayList to store the output of the Turing Machine
        ArrayList<String> output = new ArrayList<String>();
    
        // Display the transition table of the Turing Machine
        System.out.println("Transition table of a Turing Machine:");
        String[][] table = {
                { "States", " Input a ", "Input b ", "    Δ   " },
                { "  q0  ", " (q1,A,R)", "   -    ", "    -   " },
                { "  q1  ", "    -    ", "(q2,A,R)", "    -   " },
                { "  q2  ", " (q3,A,R)", "   -    ", "    -   " },
                { "  q3  ", "    -    ", "   -    ", "(q4,Δ,R)" },
                { "  q4  ", "    -    ", "   -    ", "    -   " }
        };
        print2DArray(table);
    
        // Prompt the user to provide input
        System.out.println("Please provide input (separated by space): ");
        // Read and split the input into an array
        String[] TMinput = inputs.nextLine().split(" ");
    
        // State variables to keep track of the current state of the Turing Machine
        boolean q0 = true;
        boolean q1 = false;
        boolean q2 = false;
        boolean q3 = false;
    
        // Boolean variable to indicate whether the Turing Machine has halted
        boolean halt = false;
    
        // Process each symbol in the input
        for (int i = 0; i < TMinput.length; i++) {
            String symbol = TMinput[i];
    
            // Check if the Turing Machine has not halted
            if (!halt) {
                switch (symbol) {
                    case "a":
                        // Transition rules for symbol 'a'
                        if (q0) {
                            TMinput[i] = symbol.toUpperCase();
                            q0 = false;
                            q1 = true;
                        } else if (q2) {
                            TMinput[i] = symbol.toUpperCase();
                            q2 = false;
                            q3 = true;
                        }
                        break;
                    case "b":
                        // Transition rules for symbol 'b'
                        if (q1) {
                            TMinput[i] = symbol.toUpperCase();
                            q1 = false;
                            q2 = true;
                        }
                        break;
                    case "halt":
                        // Check if the Turing Machine should halt
                        if (q3) {
                            halt = true;
                        } else {
                            // Reset state variables if halt is not reached
                            q1 = false;
                            q2 = false;
                            q3 = false;
                        }
                        break;
                    default:
                        // Handle other symbols if needed
                        break;
                }
            } else {
                // Turing Machine has halted, break the loop
                break;
            }
        }
    
        // Copy the processed input to the output ArrayList
        for (String string : TMinput) {
            output.add(string);
        }
    
        // Output the result based on whether the Turing Machine has halted
        if (halt) {
            System.out.println("Your input is accepted: " + output);
        } else {
            System.out.println("Your input is not accepted: " + output);
        }
    }
    

    public void IP() {
        // Start the solving process
        solve();
    }
    
    private void solve() {
        // Start the permutation process
        permute(0);
    }
    
    // Recursive method to generate permutations
    private void permute(int i) {
        if (i == numberOfCities - 1) {
            // Reached the end of the permutation, calculate and update the shortest distance
            int distance = calculateDistance();
            if (distance < shortestDistance) {
                // Update the shortest distance and best route
                shortestDistance = distance;
                // Use arraycopy to update the best route
                System.arraycopy(bestRoute, 0, bestRoute, 0, numberOfCities);
            }
        } else {
            // Generate permutations using backtracking
            for (int j = i; j < numberOfCities; j++) {
                swap(i, j); // Swap elements to generate permutations
                permute(i + 1); // Recursively generate permutations for the next index
                swap(i, j); // Undo the swap for backtracking
            }
        }
    }
    
    // Calculate the total distance of the current route
    private int calculateDistance() {
        int distance = 0;
        for (int i = 0; i < numberOfCities - 1; i++) {
            // Sum distances between consecutive cities
            distance += distances[bestRoute[i]][bestRoute[i + 1]];
        }
        // Add distance from the last city back to the starting city
        distance += distances[bestRoute[numberOfCities - 1]][bestRoute[0]];
        return distance;
    }
    
    // Swap two elements in the bestRoute array
    private void swap(int i, int j) {
        int temp = bestRoute[i];
        bestRoute[i] = bestRoute[j];
        bestRoute[j] = temp;
    }
    
}