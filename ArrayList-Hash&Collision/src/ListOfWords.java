import java.util.ArrayList;

public class ListOfWords {
    private HashIndexCalc hashCalculator = new HashIndexCalc();
    private int sizeOfArray = 100;
    private ArrayList<String> dataItems;

    public ListOfWords(int sizeOfArray) {
        this.sizeOfArray = sizeOfArray;
        this.dataItems = new ArrayList<>(sizeOfArray);

        for (int i = 0; i < sizeOfArray; i++)
            dataItems.add(null);
    }

    public  void addWordToArray(String word){

        int index = hashCalculator.hashIndex(word);

        if (index > sizeOfArray){
            System.out.println("End of array reached. Impossible to add!");
            return;
        }

        while(index < sizeOfArray && dataItems.get(index) != null){
            if (dataItems.get(index).equals(word)){
                System.out.println("[" + word + "] is already in the list.");
                return;
            }

            index++;
            index = index % 100;
        }

        dataItems.set(index, word);
        System.out.println("[" + word + "] added successfully at index " + index);
        System.out.println();
    }

    public void searchForWord(String word){

        int index = hashCalculator.hashIndex(word);

        if (dataItems.get(index).equals(word)) {
            System.out.println(word + " found at index " + index);
            return;
        }

        for (int i = index; i < sizeOfArray; i++){
            if (dataItems.get(i).equals(word)) {
                index = i;
                System.out.println(word + " found at index " + index);
                return;
            }
        }

        System.out.println("Entry not found.");
    }
}
