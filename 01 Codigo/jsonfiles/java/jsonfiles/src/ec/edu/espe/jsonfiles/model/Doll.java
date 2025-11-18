package ec.edu.espe.jsonfiles.model;

/**
 *
 * @author Paulo Ramos
 */

public class Doll {
    private int id;
    private String name;
    private String material;
    private double price;

    public Doll(int id, String name, String material, double price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getMaterial() { return material; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Doll(ID: " + id + ", Name: " + name +
               ", Material: " + material + ", Price: " + price + ")";
    }
}

