package test;

public class whileTest {
    public static void main(String[] args) {
        int dayOfWeek = 3;
        boolean isWeekend = false;

        // Simulating a switch with conditions using if-else statements
        if (dayOfWeek == 1) {
            System.out.println("Monday");
        } else if (dayOfWeek == 2) {
            System.out.println("Tuesday");
        } else if (dayOfWeek == 3) {
            System.out.println("Wednesday");
        } else if (dayOfWeek == 4) {
            System.out.println("Thursday");
        } else if (dayOfWeek == 5) {
            System.out.println("Friday");
        } else if (dayOfWeek == 6 || dayOfWeek == 7) {
            System.out.println("It's the weekend!");
            isWeekend = true;
        } else {
            System.out.println("Invalid day of the week");
        }

        // Additional code based on the conditions
        if (isWeekend) {
            System.out.println("Time to relax!");
        } else {
            System.out.println("Work mode...");
        }
    }
}

