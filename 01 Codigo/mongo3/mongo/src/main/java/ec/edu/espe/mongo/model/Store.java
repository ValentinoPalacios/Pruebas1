package ec.edu.espe.mongo.model;

/**
 *
 * @author Paulo Ramos
 */
public class Store {

    private int id;
    private String name;
    private float price;
    private float priceIva;

    public Store(int id, String name, float price, float priceIva) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceIva = priceIva;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the priceIva
     */
    public float getPriceIva() {
        return priceIva;
    }

    /**
     * @param priceIva the priceIva to set
     */
    public void setPriceIva(float priceIva) {
        this.priceIva = priceIva;
    }

    public float calculatePriceIva() {
        return this.price * 1.15f;
    }

}
