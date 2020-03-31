import java.io.File;
import java.io.FileNotFoundException;
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

public class Numbers {
    private Float[] numbers;
    private int capacity;
    private Scanner input = new Scanner(System.in);

    public Numbers() {
        numbers = new Float[]{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
    }

    public Numbers(int size) {
        numbers = new Float[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 0.0f;
        }
    }

    public void initValuesInArray() {
        System.out.println("Enter a float number to fill the array: ");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter value: ");
            try {
                numbers[i] = input.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("You must enter a float number. Try again: ");
                input.nextLine();
                i--;
            }
        }

        System.out.println("The array is full.");
    }

    public String toString() {
        String stringNumbers = "";

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers += numbers[i] + "\n";
        }

        return stringNumbers;
    }

    public float calcAverage() {
        float total = 0.0f;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
            if (numbers[i] != null)
                capacity++;
        }

        return (float) total / capacity;
    }

    public void numFromFile(String fileName) {
        boolean thereIsExcep = false;
        int firstNum = 0;
        Float[] tempArray = null;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] entries = line.split(" ");
            firstNum = Integer.parseInt(entries[0]);

            tempArray = new Float[firstNum];

            if (entries.length - 1 != firstNum) {
                System.out.println("Missing numbers in file");
                thereIsExcep = true;
                return;
            }

            for (int i = 0; i < firstNum; i++) {
                tempArray[i] = Float.parseFloat(entries[i + 1]);
            }

        } catch (FileNotFoundException fnf) {
            thereIsExcep = true;
            System.out.println("File was not found.");

        } catch (NumberFormatException e) {
            thereIsExcep = true;
            System.out.println("File contain non float numbers.");
        } finally {

            if (thereIsExcep == false) {

                numbers = tempArray;
            }
        }
    }

    void sortArray() {
        float insert = 0.0f;
        //holds the index to be used
        int moveItem = 0;

        for (int next = 1; next < numbers.length; next++) {
            insert = numbers[next];
            moveItem = next;


            for (int i = moveItem; i > 0; i--) {
                if (numbers[moveItem - 1] > insert) {
                    numbers[moveItem] = numbers[moveItem - 1];
                    moveItem--;
                    numbers[moveItem] = insert;
                }
            }
        }
    }

    int findApproximatePosition(float numberToFind) {
        int low = 0;
        int high = numbers.length - 1;
        int middle = (low + high) / 2;
        int location = -1;

        do {
            if (numberToFind == numbers[middle]) {
                location = middle;
            } else if (numberToFind < numbers[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }

            middle = (low + high) / 2;
        } while ((low <= high) && (location == -1));

        if (low > high) {
            location = high + 1;
        }

        return location;
    }

    void countBetweenValues(float low, float high) {
        int lower = findApproximatePosition(low);
        int higher = findApproximatePosition(high);

        int result = higher - lower;
        System.out.println("Result : " + result + " number(s) contained in that range");
    }

    public Float[] getNumbers() {
        return numbers;
    }

    int sizeArray() {
        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {
            counter++;
        }

        return counter;
    }
}