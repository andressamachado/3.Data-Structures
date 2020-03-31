/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
*/

public class RoutingTableEntry {
    private IPAddress destinationAddress;
    private String portCode;

    public RoutingTableEntry() {
    }

    //To update the information in the current object from the parameters passed into the method
    public void addEntry(IPAddress ip, String port) {
        this.destinationAddress = ip;
        this.portCode = port;
    }

    //To display this entry to a String
    public String toString() {
        return destinationAddress.toString() + " Port: " + portCode;
    }

    public String searchForPort(IPAddress newDestinationAddress) {
        if (newDestinationAddress.isEqual(this.destinationAddress)) {
            return portCode;
        } else {
            return "";
        }
    }
}
