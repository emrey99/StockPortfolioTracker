package models.stocks;

public class BaseStock implements Stock {

    String name;
    double price;
    int quantity;

    public BaseStock(String name, double price, int quantity) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getQuantity() {
        return 0;
    }
}
