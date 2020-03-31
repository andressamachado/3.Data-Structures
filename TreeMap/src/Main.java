import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        int input = 0;
        String fileName = "";

        do {
            System.out.println();
            System.out.println("Enter [1] to clear dictionary");
            System.out.println("[2] to add text from keyboard");
            System.out.println("[3] to add text from a file");
            System.out.println("[4] to search for a word count");
            System.out.println("[5] to display number of nodes");
            System.out.println("[6] to quit");

            do {
                System.out.print("Enter: ");

                try {
                    input = scanner.nextInt();

                    if (input < 1 || input > 6) {
                        System.out.print("You must enter a valid number. Try again: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("You must enter a number. Try again: ");
                    scanner.nextLine();
                }
            } while ((input < 1 || input > 6));

            switch (input) {

                case 1:
                    dictionary = new Dictionary();
                    System.out.println("You have cleared the dictionary.");
                    System.out.println();
                    break;

                case 2:

                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter the file name [ Oliver.txt]:");
                    fileName = scanner.nextLine();
                    dictionary.textFromFile(fileName);
                    break;

                case 4:
                    try {
                        scanner.nextLine();
                        System.out.print("Enter word to search for: ");
                        String wordToSearch = scanner.nextLine();
                        dictionary.numOfEntries(wordToSearch);
                    }catch (NullPointerException e){
                        System.out.println("The dictionary is empty. You must read a file or enter a sentence.");
                    }
                    break;
                case 5:
                    dictionary.printEntries();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        } while (input < 6);
    }
}

