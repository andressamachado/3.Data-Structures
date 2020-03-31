import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] data, int key) {
        int low = 0; //low end of the search area
        int high = data.length - 1; //high end of the search area
        int middle = (low + high) / 2; //middle element
        int location = -1; //return -1 if not found

        do {
            if (key == data[middle]) {
                location = middle;
            } else if (key < data[middle]) { //middle element is too high
                high = middle - 1; //eliminate the higher half
            } else { //middle element is too low
                low = middle + 1; // eliminate the lower half
            }

            middle = (low + high + 1) / 2; //recalculate the middle
        } while ((low <= high) && (location == -1));

        return location; // return the location of the search key
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = generator.ints(15, 10, 91).sorted().toArray();
        System.out.printf("%s%n%n", Arrays.toString(data));

        int searchInt = 0;
        do {
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = scanner.nextInt();

            //perform search
            int position = binarySearch(data, searchInt);

            //not found
            if (position == -1) {
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found in position %d\n\n", searchInt, position);
            }

        } while (searchInt != -1);

    }
}
