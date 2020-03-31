import java.util.LinkedList;

/***********************************************************************************
 Class:         EmailList
 Purpose:       This class will be responsible for handle the LinkedList that holds
                a group of e-mails from EmailAddress class.
 Author:        Andressa Machado [040923007]
 Course:        CST8130 - Data Structures
 Data members:  name: String - Holds the name of the list.
                list: LinkedList - Holds all the emails that are part of that list.
 Methods:       EmailList(String) - Constructor. It initializes a new list with
                the name that is passed as a parameter.
                compareTo(EmailList) : int - Used to compare to compare 2 email lists by
                their name. Uses an auxiliary function to be able to access both lists names.
                compares(String) : int - Auxiliary function that helps comparing 2 lists.
                Returns the comparision of the parameter of compareTo with the caller of
                compareTo.
                addEmail(EmailAddress) - Calls the method add(Object) from LinkedLink
                collection. Adding the EmailAddress object that was passed as a parameter
                at the end of the list.
                displayList() - Print a list in a nice format. Display the name of the list
                and all the emails in it.
                displayToDelete() - Display list with the respective "indexes", so the user
                can use it to delete an email from the list.
                deleteEmail(int) - Call remove() from the LinkedList Collection, passing an
                int, which represents the chosen index to delete.
                addAddress(Scanner)- Reads in valid address from Scanner
                size() : int - Give us the current size of the list.
 *************************************************************************************/

public class EmailList {
    private String name;
    private LinkedList<EmailAddress> list;

    public EmailList(String name) {
        this.name = name;
        this.list = new LinkedList<EmailAddress>();
    }

	public int compareTo(EmailList other) {
		return other.compares(this.name);
	}

	private int compares(String otherName) {
		return -1 * this.name.compareToIgnoreCase(otherName);
	}

    public void addEmail(EmailAddress emailAddress) {
        list.add(emailAddress);
    }

    public void displayList() {
        System.out.print(this.name + ": [");

        for (int i = 0; i < list.size(); i++) {

            if (i != list.size() - 1) {
                System.out.println(list.get(i) + ", ");
            } else {
                System.out.println(list.get(i) + "] ");
            }
        }
    }

    public void displayToDelete() {
        System.out.println(this.name);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).toString());
        }
    }

    public void deleteEmail(int index) {
        if (index <= list.size() - 1) {
            list.remove(index);
        }
    }

    public int size() {
        return list.size();
    }
}
