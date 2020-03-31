/**
 *  Student: Andressa Pessoa de Araujo Machado
 *  student number: 040923007
 *  course: CST8130_305
 *  date: 04 March 2019
 *
 *Class RoutingTableEntry
 *Purpose: This class has the purpose of adding the new entries.
 *Data Members:
 *      destinationAddress - ArrayList of type RoutingTableEntry containing the address and ports.
 *      portCode - Holds the number of addresses in the table
 *Methods:
 *      RoutingTableEntry() - Default Constructor.
 *      addEntry() - To update the information in the current object from the parameters passed into the method
 *      toString() - To display this entry to a String
 *      getIPAddress() - Return the destination IP address
 *      getPortCode() - Return the specific port
 */
public class RoutingTableEntry {
    private IPAddress destinationAddress;
    private String portCode;

    public RoutingTableEntry() {
    }

    public void addEntry(IPAddress ip, String port) {
        this.destinationAddress = ip;
        this.portCode = port;
    }

    public String toString() {
        return destinationAddress.toString() + " Port: " + portCode;
    }

    public IPAddress getIPAddress() {
        return destinationAddress;
    }

    public String getPortCode() {
        return portCode;
    }
}
