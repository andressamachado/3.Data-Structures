import java.util.Scanner;
/**
 *  Student: Andressa Pessoa de Araujo Machado
 *  student number: 040923007
 *  course: CST8130_305
 *  date: 04 March 2019
 *
 *Class Packet
 *Purpose: This class represents the packets and are extended by the DataPacket class and the RoutingPacket class.
 *         It deal with the packets and read the information from it.
 *Data Members:
 *      destinationAddress - variable of type IPAddress containing the destination address.
 *      sourceAddress - variable of type IPAddress containing the source address.
 *      packetData - Variable to hold the data that comes from the Data Packets in the router
 *Methods:
 *      Packet() - Constructor
 *      readPacket() - Read data from the Packets.txt
 *      getDestNetwork() - Returns the network address that is calculate in the IPAddress class.
 *      processFoundPacket() - Processing packet when it is found in the routing table. Default implementation, just
 *                             return false. They are extended by the DataPacket and RoutingPacket classes.
 *      processNotFoundPacket() - Processing packet when it is notfound in the routing table. Default implementation,
 *                                just return false. They are extended by the DataPacket and RoutingPacket classes.
 *      getPacketData() - Method to return the data in the packet.
 */
public class Packet {
    private IPAddress destinationAddress;
    private IPAddress sourceAddress;
    private String packetData;

    public Packet() {
        this.destinationAddress = new IPAddress();
        this.sourceAddress = new IPAddress();
        this.packetData = "";
    }

    public boolean readPacket(Scanner fileScanner) {
        destinationAddress.readAddress(fileScanner);
        sourceAddress.readAddress(fileScanner);
        packetData = fileScanner.next();

        if (!destinationAddress.isValid() ) {
            System.out.println("Invalid data....bad IPAddress " + destinationAddress.toString());
        }
        if (!sourceAddress.isValid() ) {
            System.out.println("Invalid data....bad IPAddress " + sourceAddress.toString());
        }
      return destinationAddress.isValid() && sourceAddress.isValid();
    }

    public IPAddress getDestNetwork() {
        return this.destinationAddress.getNetwork();
    }

    public boolean processFoundPacket(String destinationAddress) {
        return false;
    }

    public boolean processNotFoundPacket(String destinationAddress) {
        return false;
    }

    public String getPacketData() {
        return packetData;
    }
}


