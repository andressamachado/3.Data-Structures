/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
*/

public class DataPacket extends Packet {

    public DataPacket(){

    }
    public boolean processFoundPacket(String port) {
        System.out.println("Sending packet out " + port + " " + this.getDestNetwork().toString());
        return false;
    }

    public boolean processNotFoundPacket(String destinationAddress) {
        System.out.println("Dropping packet...." + destinationAddress);
        return false;
    }
}
