/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
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
