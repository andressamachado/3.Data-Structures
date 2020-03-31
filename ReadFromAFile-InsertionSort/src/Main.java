import java.util.InputMismatchException;
import java.util.Scanner;

/*********************************************************************************************
 *
 * Student Name: Andressa Machado
 * Student Number : 040923007
 * Course:  19W CST8130 - Data Structures
 *
 * This class contains the dynamically allocated array and it's processing. For lab 2 was added a menu option to fill the
 * array with values from a file. The first entry in the file will be the number of values that follow(ie. the size of the array).
 *
 */
public class Main {

    public static void main(String[] args) {
        Numbers numbersArray = new Numbers();
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        String fileName = "";
        boolean isSorted = false;


        do {
            System.out.println();
            System.out.println("== Menu ==");
            System.out.println("[1] to initialize a default array of 10.");
            System.out.println("[2] to initialize an array of input size.");
            System.out.println("[3] to fill array with values.");
            System.out.println("[4] to display values in array.");
            System.out.println("[5] to display average of the values in the array.");
            System.out.println("[6] to populate the array with a file contents");
            System.out.println("[7] to sort the array");
            System.out.println("[8] to display the count of how many floats values in the array");
            System.out.println("[9] to quit");
            do {
                System.out.print("Enter: ");

                try {
                    input = scanner.nextInt();

                    if (input < 1 || input > 9) {
                        System.out.println("You must enter a valid number. Try again: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You must enter a number. Try again: ");
                    scanner.nextLine();
                }
            } while ((input < 1 || input > 9));

            switch (input) {

                case 1:
                    numbersArray = new Numbers();
                    System.out.println("You have initialized an array of 10 elements maximum");
                    System.out.println();
                    isSorted = false;
                    break;
                case 2:
                    int size = 0;

                    do {
                        System.out.print("Insert an integer to be the size of the array: ");
                        try {
                            size = scanner.nextInt();
                            numbersArray = new Numbers(size);
                            System.out.println("An array of size " + size + " was created.");
                        } catch (NegativeArraySizeException | InputMismatchException e) {
                            System.out.println("You should enter a positive number. Try Again.");
                            System.out.println();
                            scanner.nextLine();
                        }
                    } while (size <= 0);
                    isSorted = false;
                    break;
                case 3:
                    numbersArray.initValuesInArray();
                    System.out.println();
                    isSorted = false;
                    break;
                case 4:
                    System.out.println(numbersArray);
                    break;
                case 5:
                    System.out.println(numbersArray.calcAverage());
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Enter the file name [ Lab2.txt | Lab2Bad1.txt | Lab2Bad2.txt | Lab2Bad3.txt | lab3test.txt]:");
                    fileName = scanner.nextLine();
                    numbersArray.numFromFile(fileName);
                    isSorted = false;
                    break;
                case 7:
                    numbersArray.sortArray();
                    isSorted = true;
                    break;
                case 8:
                    boolean validEntry;
                    float high;
                    float low;
                    try {
                        if (!isSorted) {
                            System.out.println("Cannot complete this option without sorting array firs");
                        } else {
                            do {
                                System.out.print("Enter a low value: ");
                                low = scanner.nextFloat();
                                validEntry = true;

                                if (low > numbersArray.sizeArray()) {
                                    System.out.println("Low number cannot be greater than size");
                                    validEntry = false;
                                }
                            } while (!validEntry);

                            do {
                                System.out.print("Enter a high value: ");
                                high = scanner.nextFloat();
                                validEntry = true;

                                if (high < low) {
                                    System.out.println("low number cannot be higher than the high number");
                                    validEntry = false;
                                }
                            } while (!validEntry);

                            numbersArray.countBetweenValues(low, high);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("You should enter a number");
                        validEntry = false;
                    }
                    break;
                case 9:
                    break;
                default:
                    break;
            }
        } while (input < 9);
    }
}