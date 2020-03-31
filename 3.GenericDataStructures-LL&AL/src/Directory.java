import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/***********************************************************************************
 Class:         Directory
 Purpose:       This class will be responsible for handle the ArrayList that holds
                a group of different lists - from EmailList class - populated with e-mails.
 Author:        Andressa Machado [040923007]
 Course:        CST8130 - Data Structures
 Data members:  directory: ArrayList - Holds all the lists of emails that are part of
                that directory.
 Methods:       Directory() - Constructor. It initializes a new directory with the
                size of the default value of 10.
                addList(EmailList list) - calls the method searchList() to find the position of the list
                in the arrayList.
                displayEmailLists() - Display all the current lists.
                displayList(String list) - Display a specific list. It receive a String name to be displayed.
                addAddressToList(String, Scanner) - Add the EmailAddress object to the correct list passed as a parameter.
                searchList(EmailList, boolean) : int - This method is a Binary Search implementation to find the index of a certain list
                in the directory.
                deleteFromDirectory(String, Scanner) - Deletes an email address from a given list.
                findEmailList(String) : EmailList - Retuns a desired list.
                addFromFile(String, Scanner) - Populate the directory with lists of emails from a external file.
                isEmpty() : boolean - Return if the directory is empty.
 *************************************************************************************/
public class Directory {
    private ArrayList<EmailList> directory;

    public Directory() {
        this.directory = new ArrayList<>();
        //default size 10
    }

    public void addList(EmailList list) {
        //int to hold the index to be used at the moment of adding the new list.
        int positionToAdd = this.searchList(list, true);

        //If the directory is not empty AND the position to add the list is greater than 0( in an alphabetical order,
        // comes after ), increase the index number by 1.
        if (!directory.isEmpty() && list.compareTo(directory.get(positionToAdd)) > 0) {
            positionToAdd++;
        }

        directory.add(positionToAdd, list);
    }

    public void displayEmailLists() {
        //Prints only if the directory is not empty.
        if (!directory.isEmpty()) {
            System.out.println("The email lists are: ");
        }

        for (int i = 0; i < directory.size(); i++) {
            directory.get(i).displayList();
            System.out.println();
        }
    }

    public void displayList(String list) {
        //EmailList object created to be used as a reference at the moment of searching for the list in the searchList()
        EmailList ref = new EmailList(list);

        //If the serachList() returns -1: it means that the list was not found
        if (searchList(ref, false) < 0) {
            System.out.println("List not found");
        } else {
            //search for a list with the same name as the reference and return the index of that list.
            directory.get(searchList(ref, false)).displayList();
        }
    }

    public void addAddressToList(String list, Scanner in) {
        //Holds the list to add the address to it.
        EmailList ref = findEmailList(list);

        //If the ref is null, means the list was not found
        if (ref == null) {
            System.out.println("List not found");
        } else {
            //Ask the user to enter the email address
            System.out.println("Enter valid email address: ");
            String newEmail = in.nextLine();
            //Create a new EmailAddress object
            EmailAddress email = new EmailAddress(newEmail);

            //Searching for the list where the user wants to add the address.
            directory.get(searchList(ref, false)).addEmail(email);
        }
    }

    //BinarySearch
    //searchingToAdd - flag to control the return of the index in the list
    public int searchList(EmailList list, boolean searchingToAdd) {
        int low = 0;
        int middle = -1;
        int index = -1;
        int high = directory.size() - 1;

        //If the list is empty, return 0 to be used as index.
        if (this.isEmpty()) {
            return 0;
        }

        while (low <= high) {
            middle = (low + high) / 2;

            //Holds the result of the comparision between the list passed as parameter and the middle of the directory.
            //compareTo returns a positive number, 0 or a negative number. Which is been used to put the lists in
            //an alphabetical order.
            int compareValue = list.compareTo(directory.get(middle));

            //Negative number: comes before. Set the high value to be middle - 1
            //0: list found.
            if (compareValue < 0) {
                high = middle - 1;
            } else if (compareValue > 0) {
                low = middle + 1;

            } else if (compareValue == 0) {
                return middle;
            }
        }

        //returning the closest index.
        if (searchingToAdd && index == -1) {
            return middle;
        }

        return index;
    }

    public void deleteFromDirectory(String list, Scanner in) {
        //Reference to hold the list to be deleted from
        EmailList ref = findEmailList(list);
        int index = 0;

        if (ref == null) {
            System.out.println("List not found");
        } else {
            //Display with the "indexes".
            ref.displayToDelete();
            System.out.println();

            try {
                do {
                    System.out.print("Enter entry number to delete: ");
                    index = in.nextInt();

                    //controls if the user enter an index out of the bounds
                    if (index < 0 || index > ref.size() - 1) {
                        System.out.println("Index out of bounds.");
                    }

                } while (index < 0 || index > ref.size() - 1);
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number.");
            }
            in.nextLine();

            //delete the email from the list.
            directory.get(searchList(ref, false)).deleteEmail(index);
        }
    }

    public EmailList findEmailList(String list) {
        //Reference to hold the same name as the list to be found
        EmailList ref = new EmailList(list);
        //find the index of the desired list
        int index = searchList(ref, false);

        if (index < 0) {
            return null;
        } else {
            return directory.get(index);
        }
    }

    public void addFromFile(String fileName, Scanner scanner) {
        File file = new File(fileName);
        int controlLists = 0;
        int controlEmails = 0;
        int numberOfLists = 0;

        try {
            scanner = new Scanner(file);
            //Converts a String to an Integer
            numberOfLists = Integer.parseInt(scanner.next());
            String listName;
            //int numOfEmails = 0;
            //Holds the email to be added
            String email = "";
            //Holds the name of the list
            EmailList listFromFile;

            do {
                listName = scanner.next();
                //Create the new list
                listFromFile = new EmailList(listName);
                //Control the number of lists
                controlLists++;
                //Number right after List Name in the file
                int numberOfEmails = Integer.parseInt(scanner.next());

                //Reads the email addresses in each list and add them
                for (int i = 0; i < numberOfEmails; i++) {
                    email = scanner.next();
                    //Create a new email
                    EmailAddress emailFromFile = new EmailAddress(email);
                    listFromFile.addEmail(emailFromFile);
                    //Control the number of emails added
                    controlEmails++;
                }
                //Adds the list to the directory
                this.addList(listFromFile);
                //while the number of lists added is less than the number of lists -specified in the file-.
            } while (controlLists < numberOfLists);

            if (scanner.hasNext()) {
                System.out.println("File has more lists than was specified. " +
                        "\nIgnoring remaining lists... ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (InputMismatchException e) {
            System.out.println("Value invalid in file");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Value invalid in file");
            return;
        }

        if (controlLists != numberOfLists) {
            System.out.println("Number of lists does not match");
        }

        scanner.close();
    }

    public boolean isEmpty() {
        return directory.isEmpty();
    }
}
