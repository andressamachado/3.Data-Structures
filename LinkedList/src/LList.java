
public class LList {
    private LLNode head;

    public LList() {
        head = null;
    }

    public void addAtHead(String newData) {
        LLNode newNode = new LLNode(newData);
        newNode.updateNode(head);
        head = newNode;
    }

    public void display() {
        LLNode temp = head;

        if (head == null) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Actual list is: ");
            while (temp != null) {
                System.out.println(temp);
                temp = temp.getNext();
            }
        }
    }

    public LLNode deleteAtHead() {
        LLNode removedOne = head;
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        } else {
            System.out.print("Deleting the first element...");
            System.out.print("The one deleted is..." + removedOne);
            head = head.getNext();
            return removedOne;
        }
    }

    public boolean deleteMiddle(String element) {
        LLNode current = head;

        // lista vazia
        if (current == null) {
            System.out.println("List is empty.");
            return false;
        }

        // 1o elemento
        if (head.getData().equalsIgnoreCase(element)) {
            deleteAtHead();
            return true;
        }

        do {
            if (current.getNext() == null) {
                return false;
            }
            if (current.getNext().getData().equalsIgnoreCase(element)) {
                System.out.print("Deleting element...");
                System.out.print("The one deleted is..." + current.getNext().getData());
                current.updateNode(current.getNext().getNext());
                return true;
            } else {
                current = current.getNext();
            }
        } while (current.getNext() != null);


        System.out.println("String is not in the list");
        return true;
    }
}
