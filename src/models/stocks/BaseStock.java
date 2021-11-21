package models.stocks;

import static common.constants.ExceptionMessages.*;

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
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_STOCK_NAME);
        }

        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0){
            throw new IllegalArgumentException(INVALID_STOCK_PRICE);
        }

        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException(INVALID_QUANTITY);
        }

        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
