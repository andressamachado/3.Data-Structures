import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i;
            for (int index = i + 1; index < data.length; index++) {
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }
            swap(data, i, smallest);
        }
    }

    public static void swap(int[] data, int first, int second) {
        int temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int[] data = generator.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted Array: %s%n%n", Arrays.toString(data));
        selectionSort(data);
        System.out.printf("%nSorted Array: %s%n", Arrays.toString(data));
    }
}
