
package ec.edu.espe.jsonfiles.view;

/**
 *
 * @author Paulo Ramos
 */

import ec.edu.espe.jsonfiles.model.Doll;
import ec.espe.edu.jsonfiles.controller.DollController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DollController controller = new DollController();
        controller.loadFromJson("dolls.json");

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese ID Doll (integer): ");
                int id = Integer.parseInt(sc.nextLine());

                boolean exists = controller.getDolls().stream()
                        .anyMatch(d -> d.getId() == id);

                if (exists) {
                    System.out.println("ID already exists.");
                    continue;
                }

                System.out.print("Doll name: ");
                String name = sc.nextLine();

                System.out.print("Ingrese Doll material: ");
                String material = sc.nextLine();

                System.out.print("Ingrese Doll price: ");
                double price = Double.parseDouble(sc.nextLine());

                if (price < 0) {
                    System.out.println("Price must be positive.");
                    continue;
                }

                controller.addDoll(new Doll(id, name, material, price));

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            System.out.print("Add another Doll? (y/n): ");
            if (!sc.nextLine().equalsIgnoreCase("y")) break;
        }

        controller.displayDolls();
        controller.saveToJson("dolls.json");
        System.out.println("Data saved in dolls.json");
    }
}

