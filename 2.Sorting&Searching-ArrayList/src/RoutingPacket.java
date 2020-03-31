/**
 *  Student: Andressa Pessoa de Araujo Machado
 *  student number: 040923007
 *  course: CST8130_305
 *  date: 04 March 2019
 *
 *Class RoutingPacket
 *Purpose: This class extends the Packet class and represents an address to be added.
 *Data Members:
 *      There is no data member for this class.
 *Methods:
 *      RoutingPacket() - Default constructor.
 *      processFoundPacket() - Produces a correct message. In case the packet is a Routing Packet, a message saying that
 *      the entry is already in the table is produced.
 *      processNotFoundPacket() - Produces a correct message. In case the table does not have that entry yet, it produces
 *      a message saying that it is being added.
 */

public class RoutingPacket extends Packet {

    public RoutingPacket() {
    }
    public boolean processFoundPacket(String destinationAddress) {
        System.out.println("Entry is already in the routing table " + this.getDestNetwork().toString());
        return false;
    }

    public boolean processNotFoundPacket(String destinationAddress) {
        System.out.println("Adding entry to routing table " + destinationAddress);
        return true;
    }

}
