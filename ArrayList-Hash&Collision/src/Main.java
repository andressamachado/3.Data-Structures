import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListOfWords list = new ListOfWords(100);
        String choice = "q";

        do {
            System.out.println("===== Lab 8 - ArrayListHash =====");
            System.out.println("[A] to add a String to array");
            System.out.println("[S] to search for a string in the array");
            System.out.println("[Q] to quit");
            System.out.print("Enter: ");

            try {
                choice = scanner.next().toLowerCase();
            } catch (InputMismatchException e) {
                choice = "z";
            }

            switch (choice) {
                case "a":
                    System.out.print("Enter a string: ");
                    String toBeAdded = scanner.next().toLowerCase();
                    list.addWordToArray(toBeAdded);
                    break;

                case "s":
                    System.out.print("Enter a string: ");
                    String toBeSearched = scanner.next().toLowerCase();
                    list.searchForWord(toBeSearched);
                    break;

                case "q":
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (!choice.equals("q"));
    }
}
