import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *  Student: Andressa Pessoa de Araujo Machado
 *  student number: 040923007
 *  course: CST8130_305
 *  date: 04 March 2019
 *
 *Class Router
 *Purpose: This class has all the main functions of the router.
 *Data Members:
 *      routingTable - ArrayList of type RoutingTableEntry containing the address and ports.
 *      numberOfAddresses - Holds the number of addresses in the table
 *      maxNumberOfEntries - Holds the number of addresses the user wants to save in the table.
 *Methods:
 *      Router() - Constructor. Asks for the number of entries the user wants in the table.
 *      processPackets()
 *      displayTable()
 *      addEntryToTable()
 *      binarySearch()
 *      createNewEntry()
 */

public class Router {
    private ArrayList<RoutingTableEntry> routingTable;
    private int numberOfAddresses;
    private int maxNumberOfEntries;

    public Router() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter number of entries maximum for array: ");
            try {
                maxNumberOfEntries = scanner.nextInt();
                if (maxNumberOfEntries <= 0) {
                    System.out.println("You must enter a positive number. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a valid number. Try again.");
                scanner.nextLine();
                maxNumberOfEntries = -1;
            }
        } while (maxNumberOfEntries <= 0);

        routingTable = new ArrayList<RoutingTableEntry>();
    }

    public void processPackets(Packet packet) {
        String port = "";

        int portIndex = binarySearch(routingTable, packet.getDestNetwork(), false);

        if (portIndex != -1) {
            port = routingTable.get(portIndex).getPortCode();
        }

        if (port.equals("")) {
            boolean needToAddEntry = packet.processNotFoundPacket(packet.getDestNetwork().toString());

            if (needToAddEntry) {
                if (maxNumberOfEntries > numberOfAddresses) {
                    RoutingTableEntry rte = createNewEntry(packet.getDestNetwork(), packet.getPacketData());
                    addEntryToTable(rte);
                } else {
                    System.out.println("Table is full.........cannot add " + packet.getDestNetwork().toString());
                }
            }
        } else {
            packet.processFoundPacket(port);
        }
    }

    public void displayTable() {

        System.out.println();
        System.out.println("Routing table...");
        System.out.println();

        for (int i = 0; i < numberOfAddresses; i++) {
            System.out.println(routingTable.get(i).toString());
        }
    }

    public void addEntryToTable(RoutingTableEntry rte) {

        //if the list is empty, add right away and return.
        if (routingTable.size() == 0) {
            routingTable.add(0, rte);
            numberOfAddresses++;
            return;
        }

        // Look for position where to add the new entry.
        int lastIndexChecked = binarySearch(routingTable, rte.getIPAddress(), true);
        int positionChange = 0;

        // Extra check to see if new entry goes before or after the last checked index.
        if (routingTable.get(lastIndexChecked).getIPAddress().isEqual(rte.getIPAddress())) {
            positionChange = 0;
        } else {
            if (!routingTable.get(lastIndexChecked).getIPAddress().isGreaterThan(rte.getIPAddress())) {
                positionChange = 1;
            }
        }

        routingTable.add(lastIndexChecked + positionChange, rte);
        numberOfAddresses++;
    }

    //Implementation of the binary search algorithm using the IP Address comparison methods isEqual() and isGreaterThan()
    //This method has an extra parameter because it is used in two situations
    //situation 1: When just searching, it either finds the element or return -1.
    //situation 2: It is searching to add something later; If does not find the element it returns the last checked position
    public int binarySearch(List<RoutingTableEntry> sortedArray, IPAddress newOne, boolean searchingToAdd) {
        int index = -1;
        int mid = -1;
        int low = 0;
        int high = sortedArray.size() - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            boolean isMidEqual = sortedArray.get(mid).getIPAddress().isEqual(newOne);
            boolean isMidLessThan = !sortedArray.get(mid).getIPAddress().isGreaterThan(newOne) && !isMidEqual;
            boolean isMidGreaterThan = sortedArray.get(mid).getIPAddress().isGreaterThan(newOne);

            if (isMidLessThan) {
                low = mid + 1;
            } else if (isMidGreaterThan) {
                high = mid - 1;
            } else if (isMidEqual) {
                index = mid;
                break;
            }
        }

        if (searchingToAdd && index == -1) {
            return mid;
        }

        return index;
    }

    public RoutingTableEntry createNewEntry(IPAddress ip, String port) {
        RoutingTableEntry r = new RoutingTableEntry();
        r.addEntry(ip, port);
        return r;
    }

}