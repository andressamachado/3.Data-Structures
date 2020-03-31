import java.util.InputMismatchException;
import java.util.Scanner;
/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
*/

public class Router {
    private RoutingTableEntry[] routingTable;
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
        routingTable = new RoutingTableEntry[maxNumberOfEntries];
    }

    public void processPackets(Packet packet) {
        String port = "";

        for (int i = 0; i < numberOfAddresses; i++) {
            if (port.equals("")) {
                port = routingTable[i].searchForPort(packet.getDestNetwork());
            }
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
            System.out.println(routingTable[i].toString());
        }
    }

    public void addEntryToTable(RoutingTableEntry rte) {
        routingTable[numberOfAddresses] = rte;
        numberOfAddresses++;
    }

    public void extendTable() {
        RoutingTableEntry[] temp = new RoutingTableEntry[routingTable.length + 10];


        for (int i = 0; i < numberOfAddresses; i++) {
            temp[i] = routingTable[i];
        }

        routingTable = temp;
        maxNumberOfEntries = temp.length;
    }

    public RoutingTableEntry createNewEntry(IPAddress ip, String port) {
        RoutingTableEntry r = new RoutingTableEntry();
        r.addEntry(ip, port);
        return r;
    }

}
