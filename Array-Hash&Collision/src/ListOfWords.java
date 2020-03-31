public class ListOfWords {
    private HashIndexCalc hashIndexCalc = new HashIndexCalc();
    private String[] dataItems;

    public ListOfWords() {
        dataItems = new String[100];
    }

    public void addWordToArray(String word){
        int index = hashIndexCalc.hashIndex(word);

        if (index > dataItems.length){
            System.out.println("End of array reached. Impossible to add!");
            System.out.println();
            return;
        }

        while(index < dataItems.length && dataItems[index] != null){
            if (dataItems[index].equals(word)) {
                System.out.println("[" + word + "] is already in the list.");
                System.out.println();
                return;
            }
            index++;
            index = index % 100;
        }

        dataItems[index] = word;
        System.out.println("[" + word + "] added successfully at index " + index);
        System.out.println();
    }

    public void searchForWord(String word){
        int index = hashIndexCalc.hashIndex(word);

        if (dataItems[index].equals(word)){
            System.out.println("[" + word + "] found at index " + index);
            return;
        }

        for (int i = index; i < dataItems.length; i++){
            if (dataItems[i].equals(word)) {
                index = i;
                System.out.println(word + " found at index " + index);
                return;
            }
        }

        System.out.println("Entry not found.");
    }
}
