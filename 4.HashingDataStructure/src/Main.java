import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/***************************************************************************************
 * Class Main
 * Purpose: This class has the purpose of represent a software of a router.
 *
 * Student: Andressa Pessoa de Araujo Machado
 * student number: 040923007
 * course: CST8130_305
 * date: 08 April 2019
 *
 * method main - This program ask the user  for name of a file and connects to that file,
 * then reads each line of the file as a packet and processes it(either data packet or routing protocol packet based
 * on first chair input on the line)
 ***************************************************************************************/
public class Main {

    public static void main(String[] args) {
        Router router = new Router();
        String type;
        Scanner scanner = new Scanner(System.in);
        boolean hasFile = true;
        boolean validIP = true;

        System.out.print("Enter name of file to process (Packets): ");
        String fileToRead = scanner.nextLine();


        try {
            Packet packet = new Packet();
            File file = new File(fileToRead + ".txt");
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                type = scanner.next();
                if (type.equals("p")) {
                    packet = new RoutingPacket();
                    validIP = packet.readPacket(scanner);
                }
                if (type.equals("d")) {
                    packet = new DataPacket();
                    validIP = packet.readPacket(scanner);
                }
                if(validIP) {
                    router.processPackets(packet);
                }
            }
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not found");
            hasFile = false;
        }

        if(hasFile) {
            router.displayTable();
        }

        scanner.close();
    }
}
