import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text;
        String more = "";
        StringBuilder sb = new StringBuilder();

        do {

            System.out.print("Enter a string: ");
            text = scanner.nextLine();

            if (text.equals("")) {
                System.out.println("The String cannot be empty");
                continue;
            }

            String[] words = text.split(" ");

            for (int i = 0; i < words.length; i++) {
                sb.append(words[i]);
            }

            text = sb.toString().toLowerCase();

            if (testPalindrome(text, 0)) {
                System.out.print("This string is a palindrome. Do another (Y/N)? ");
                more = scanner.nextLine();
            } else {
                System.out.print("This string is not a palindrome. Do another (Y/N)?");
                more = scanner.nextLine();
            }
            sb.setLength(0);
        } while (more.equalsIgnoreCase("y") || more.equalsIgnoreCase("yes"));
    }

    private static boolean testPalindrome(String text, int position) {

        int size = text.length() - 1;

        if (position > text.length() / 2) {
            return true;
        }

        if (text.charAt(position) == text.charAt(size - position)) {
            return testPalindrome(text, ++position);
        } else
            return false;
    }
}

