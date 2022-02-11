package org.kacperski.shop.model;

public class Product {

    // == fields ==
    private String name;
    private double price;

    // == constructors ==
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // == public methods ==
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
