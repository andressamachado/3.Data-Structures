import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedListExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        LList list = new LList();

        do {
            System.out.println("============= MENU =============");
            System.out.println("[1] Adding to head");
            System.out.println("[2] Deleting from the head");
            System.out.println("[3] Displaying a linked listed");
            System.out.println("[4] Deleting a string from the list");
            System.out.println("[0] Quit");
            System.out.print("\nPlease, select an option:");

            do {

                try {
                    input = scanner.nextInt();

                    if (input < 0 || input >= 5) {
                        System.out.print("Select a valid option [1], [2], [3], [4], or [0]:");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("You must enter a number. \nSelect a valid option [1], [2], [3], [4], or [0]:");
                    scanner.nextLine();
                }

            } while (input < 0 || input >= 5);

            String userString = scanner.nextLine();

            switch (input) {

                case 1:
                    System.out.print("Enter the String you want to add: ");
                    userString = scanner.nextLine();
                    list.addAtHead(userString);
                    System.out.println("\"" + userString + "\" was added");
                    break;
                case 2:
                    LLNode removedOne = list.deleteAtHead();
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.print("Enter the element you want to delete:");
                    userString = scanner.nextLine();
                    list.deleteMiddle(userString);
                    break;
            }
            System.out.println();
            System.out.println();
        } while (input != 0);

    }

}
