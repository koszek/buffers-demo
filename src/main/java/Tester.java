import java.util.Scanner;

public class Tester {

    public static void main(String... args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                return;
            }
            Template template;

            if (command.equals("serialize plain proto")) {
                template = new SerializePlainProto();
            } else if (command.equals("serialize plain flat")) {
                template = new SerializePlainFlat();
            } else if (command.equals("deserialize plain proto")) {
                template = new DeserializePlainProto();
            } else if (command.equals("deserialize plain flat")) {
                template = new DeserializePlainFlat();
            } else if (command.equals("partial deserialize plain flat")) {
                System.out.println("Enter field count:");
                template = new PartialDeserializePlainFlat(scanner.nextInt());
            } else if (command.equals("serialize nested proto")) {
                template = new SerializeNestedProto();
            } else if (command.equals("serialize nested flat")) {
                template = new SerializeNestedFlat();
            } else if (command.equals("deserialize nested proto")) {
                template = new DeserializeNestedProto();
            } else if (command.equals("deserialize nested flat")) {
                template = new DeserializeNestedFlat();
            } else if (command.equals("partial deserialize nested flat")) {
                System.out.println("Enter field count:");
                template = new PartialDeserializeNestedFlat(scanner.nextInt());
            } else if (command.equals("deserialize and mutate plain flat")) {
                template = new DeserializeAndMutatePlainFlat();
            } else {
                continue;
            }

            long averageTime = new Runner(template).run();
            System.out.println("Average = " + averageTime);
        }
    }
}
