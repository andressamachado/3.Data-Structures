/***************************************************************************************
 *Student: Andressa Pessoa de Araujo Machado
 *student number: 040923007
 *course: CST8130_305
 *date: 08 April 2019
 *
 *Class Router
 *Purpose:
 *          This class has all the main functions of the router.
 *Data Members:
 *          routingTable        - ArrayList of type RoutingTableEntry containing the address and ports.
 *          numberOfAddresses   - Holds the number of addresses in the table
 *          maxNumberOfEntries  - Holds the number of addresses the user wants to save in the table.
 *Methods:
 *          Router()            - Constructor. Asks for the number of entries the user wants in the table.
 *          processPackets()    - Processes the packet rather it was found in the table or not.
 *          displayTable()      - Displays table in a nice format
 *          addEntryToTable()   - Adds entry to table in case it is not already there
 *          createNewEntry()    - Creates a new Router table entry.
 ***************************************************************************************/
public class Router {
    private RoutingTableEntry[] routingTable;
    private int numberOfAddresses;
    private int maxNumberOfEntries;

    public Router() {
        maxNumberOfEntries = 100;
        numberOfAddresses = 0;
        routingTable = new RoutingTableEntry[maxNumberOfEntries];
    }

    public void processPackets(Packet packet) {
        String port = "";
        int index = packet.calcHash(100);

        if (routingTable[index] == null) {
            System.out.println("Routing table entry not found.");
        } else {
            port = routingTable[index].searchForPort(packet.getDestNetwork());
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

        for (int i = 0; i < routingTable.length; i++) {
            if (routingTable[i] == null) {
                System.out.println("[" + i + "] null");
            } else {
                System.out.println("[" + i + "]" + routingTable[i].toString());
            }
        }
    }

    public void addEntryToTable(RoutingTableEntry rte) {
        int index = rte.calcHash(100);
        while (routingTable[index] != null && index < routingTable.length) {
            if (routingTable[index].isEqual(rte)){
                return;
            }
            if (index > routingTable.length) {
                System.out.println("Routing table is full. Entry cannot be added.");
                return;
            }
            index++;
            index = index % 100;
        }
            routingTable[index] = rte;
            System.out.println("Entry at index [" + index + "]: " + routingTable[index]);
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
