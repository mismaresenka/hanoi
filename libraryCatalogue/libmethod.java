package libraryCatalogue;

import java.util.HashMap;
import java.util.Scanner;

class LibMethod implements Catalogue {
    private static final int TABLE_SIZE = 10;
    private static libBook[] hashTable = new libBook[TABLE_SIZE];

    @Override
    public void catalogue() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. Insert a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. Delete a Book");
            System.out.println("4. Display Catalog");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    insertBook(scanner);
                    break;
                case 2:
                    searchBook(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    displayCatalog();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void insertBook(Scanner scanner) {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        int index = hash(isbn);
        while (hashTable[index] != null) {
            index = (index + 1) % TABLE_SIZE; // Linear probing
        }

        hashTable[index] = new libBook(isbn, title);
        System.out.println("Book inserted successfully.");
        displayCatalog();
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter ISBN to search: ");
        String isbn = scanner.nextLine();

        int index = findBook(isbn);
        if (index != -1) {
            System.out.println("Book found at index " + index + ": " + hashTable[index]);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter ISBN to delete: ");
        String isbn = scanner.nextLine();

        int index = findBook(isbn);
        if (index != -1) {
            hashTable[index] = null;
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }

        displayCatalog();
    }

    private static void displayCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("Slot " + i + ": " + (hashTable[i] != null ? hashTable[i] : "NULL"));
        }
    }

    private static int hash(String isbn) {
        // Simple hash function for demonstration purposes
        return Math.abs(isbn.hashCode() % TABLE_SIZE);
    }

    private static int findBook(String isbn) {
        int index = hash(isbn);
        int originalIndex = index;

        while (hashTable[index] != null && !hashTable[index].getIsbn().equals(isbn)) {
            index = (index + 1) % TABLE_SIZE; // Linear probing
            if (index == originalIndex) {
                return -1; // Book not found, and we've checked all slots
            }
        }

        return index;
    }
}
