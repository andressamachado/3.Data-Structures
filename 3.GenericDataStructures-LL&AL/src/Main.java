import java.util.Scanner;

/*
 * Student: Andressa Pessoa de Araujo Machado
 * student number: 040923007
 * course: CST8130_305
 * 25.March.2019
 *
 * Assignment#3 - Email List
 * The purpose of this program is to system to manage email address lists.
 */

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        Directory directory = new Directory();
        int control = 1;

        do {
            System.out.println();
            System.out.println("Enter:");
            System.out.println("\t[c] to create a new list");
            System.out.println("\t[p] to display all lists");
            System.out.println("\t[a] to add an entry to a list");
            System.out.println("\t[d] to delete from a list");
            System.out.println("\t[l] to display a list");
            System.out.println("\t[f] to load list from file");
            System.out.print("\t[q] to quit: ");

            input = scanner.nextLine();

            switch (input) {

                case "C":
                case "c":
                    System.out.print("Enter the name of the list: ");
                    input = scanner.nextLine();
                    EmailList emailList = new EmailList(input);
                    directory.addList(emailList);

                    do {
                        EmailAddress newEmail = new EmailAddress();
                        newEmail.addAddress(scanner, "y");
                        emailList.addEmail(newEmail);
                        scanner.nextLine();
                        System.out.print("Another? y/n: ");
                        input = scanner.nextLine();
                    } while (input.equalsIgnoreCase("y"));
                    break;

                case "P":
                case "p":
                    System.out.println();
                    directory.displayEmailLists();
                    break;

                case "A":
                case "a":
                    System.out.print("Enter name of list to add to: ");
                    input = scanner.nextLine();
                    directory.addAddressToList(input, scanner);
                    break;

                case "D":
                case "d":
                    System.out.print("Enter name of list to delete from: ");
                    input = scanner.nextLine();
                    directory.deleteFromDirectory(input, scanner);
                    break;

                case "L":
                case "l":
                    System.out.print("Enter name of list to display: ");
                    input = scanner.nextLine();

                    directory.displayList(input);
                    break;

                case "F":
                case "f":
                    System.out.println("Enter name of file to process:");
                    input = scanner.nextLine();

                    directory.addFromFile(input, scanner);
                    break;

                case "Q":
                case "q":
                    control = 0;
                    break;

                default:
                    System.out.print("Option not found.");
                    System.out.println();
                    break;
            }


        } while (!input.equalsIgnoreCase("q") || control == 1);
        scanner.close();
    }

}
