import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

    public static int linearSearch(int[] data, int searchKey) {

        for (int index = 0; index < data.length; index++) {
            if (data[index] == searchKey) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = new int[10];

        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + generator.nextInt(90);
        }

        //could be used instead:
        //int[] data = generator.ints(10,10,91).toArray();
        //first argument: the numbers of elements in the stream.
        //second and third : random ints values it produces will be in the range 10 up to (but not including) 91.

        System.out.printf("%s%n%n", Arrays.toString(data));

        int searchInt;

        do {
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = scanner.nextInt();

            //perform search
            int position = linearSearch(data, searchInt);

            //not found
            if (position == -1) {
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found in position %d\n\n", searchInt, position);
            }

        } while (searchInt != -1);
    }
}
