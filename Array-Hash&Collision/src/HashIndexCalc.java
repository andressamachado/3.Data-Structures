public class HashIndexCalc {

    public int hashIndex(String word) {
        if (word.length() < 2)
            return word.charAt(0) % 100;
        else
            return (word.charAt(0) + word.charAt(1)) % 100;
    }

}