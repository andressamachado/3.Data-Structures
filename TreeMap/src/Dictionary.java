import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

class Dictionary {
    private Scanner scanner = new Scanner(System.in);
//    private String[] words = new String[5];
    TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    void textFromFile(String fileName) {
        String line = "";

        try {
            File file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.next();
                line = line.replaceAll("\\W", "");
                line = line.toLowerCase();
                addToDictionary(line);
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("File was not found.");
        }

    }

    void addToDictionary(String word) {

        if(map.containsKey(word)){
            map.replace(word, map.get(word), map.get(word)+1);
        } else {
            map.put(word,1);
        }

    }

    void numOfEntries(String wordToSearch) {

        System.out.println(map.get(wordToSearch));
    }

    public void printEntries() {
        System.out.println(map.keySet().size());
    }
}
