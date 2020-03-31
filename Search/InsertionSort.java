import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] data) {

        for (int next = 1; next < data.length; next++) {
            int insert = data[next];
            int moveItem = next;

            while (moveItem > 0 && data[moveItem - 1] > insert) {
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }

            data[moveItem] = insert;
        }
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int[] data = generator.ints(10, 10, 91).toArray();
        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
        insertionSort(data);
        System.out.printf("Sorted array: %s%n", Arrays.toString(data));
    }
}
