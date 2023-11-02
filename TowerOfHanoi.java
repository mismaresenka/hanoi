import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        redSmall red = new redSmall();
        whiteMedium white = new whiteMedium();
        greenLarge green = new greenLarge();

        Stack<String> T1 = new Stack<String>();
        Stack<String> T2 = new Stack<String>();
        Stack<String> T3 = new Stack<String>();

        T1.push(green.colorDeclaration());
        T1.push(white.colorDeclaration());
        T1.push(red.colorDeclaration());

        displayTowers(T1, T2, T3);

        towerOfHanoi(T1.size(), T1, T3, T2);

        // Print the final state of the towers
        displayTowers(T1, T2, T3);
    }

    public static void towerOfHanoi(int n, Stack<String> source, Stack<String> destination, Stack<String> auxiliary) {
        if (n > 0) {
           
            towerOfHanoi(n - 1, source, auxiliary, destination);

            // Move the nth disk from source to destination
            String disk = source.pop();
            destination.push(disk);

           
            displayTowers(source, auxiliary, destination);

         
            towerOfHanoi(n - 1, auxiliary, destination, source);
        }
    }

    public static void displayTowers(Stack<String> T1, Stack<String> T2, Stack<String> T3) {
        System.out.println("Tower 1: " + T1);
        System.out.println("Tower 2: " + T2);
        System.out.println("Tower 3: " + T3);
        System.out.println("------------------------");
    }
}
