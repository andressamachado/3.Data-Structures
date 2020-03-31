import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
* Student: Andressa Pessoa de Araujo Machado
* student number: 040923007
* course: CST8130_305
*
* note: I am sorry for the headers, got stuck and I just dont have time to complete this requirement.*/

public class Main {

    public static void main(String[] args) {
        Router router = new Router();
        String type;
        Scanner scanner = new Scanner(System.in);
        boolean hasFile = true;
        boolean validIP = true;

        System.out.print("Enter name of file to process(Packets): ");
        String fileToRead = scanner.nextLine();

        try {
            Packet packet = new Packet();
            File file = new File(fileToRead + ".txt");
            scanner = new Scanner(file);
            System.out.println();
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
