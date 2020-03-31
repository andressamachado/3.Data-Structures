/*****************************************************************************************
 *Student: Andressa Pessoa de Araujo Machado
 *student number: 040923007
 *course: CST8130_305
 *date: 08 April 2019
 *
 *Class DataPacket
 *Purpose:
 *      This class extends the Packet class and represents a Data Packet type.
 *Data Members:
 *      There is no data member for this class.
 *Methods:
 *      DataPacket()            - Default constructor.
 *      processFoundPacket()    - Produces a correct message. In case the packet is a Data Packet, a sending packet
 *                                message is produced.
 *      processNotFoundPacket() - Produces a correct message. In case the program try to send the packet and the address
 *                                is not found in the table .
 ***************************************************************************************/

public class DataPacket extends Packet {

    public DataPacket(){ }
    public boolean processFoundPacket(String port) {
        System.out.println("Sending packet out " + port + " " + this.getDestNetwork().toString());
        return false;
    }

    public boolean processNotFoundPacket(String destinationAddress) {
        System.out.println("Dropping packet...." + destinationAddress);
        return false;
    }
}
