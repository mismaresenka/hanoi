package stackQueue;

import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;

public class stackClass extends methodStack {

    private Stack<String> stack_enqueue = new Stack<String>();
    private Stack<String> stack_dequeue = new Stack<String>();

    public void stackIni() {

        Scanner input = new Scanner(System.in);

        System.out.println("Input preffered papers: ");
        int quantity = input.nextInt();

        for (int n = 1; n <= quantity; n++) {
            String paper = "Paper " + "(" + n + ")";
            stack_enqueue.push(paper);
        }
    }

    public void stackDeclut() {
        while (!stack_enqueue.isEmpty()) {
            stack_dequeue.push(stack_enqueue.pop());
            System.out.println("\nPrinter Queue:");
            System.out.println("\nPrinter 1:" + stack_enqueue);
            System.out.println("\nPrinter 2:" + stack_dequeue);
        }
        String[] paperArray = new String[stack_dequeue.size()];
        int index = stack_dequeue.size() - 1;
        while (!stack_dequeue.isEmpty()) {
            paperArray[index--] = stack_dequeue.pop();
        }

        if (stack_dequeue.isEmpty() && stack_enqueue.isEmpty()){
            System.out.println("\nThe print queue is now empty.");
        }

        System.out.println("Printed paper: ");

        for(String n : paperArray){
            System.out.println(n);
        }
    }

    Node root;
}
