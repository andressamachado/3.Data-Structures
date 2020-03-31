import java.util.Scanner;
/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
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


