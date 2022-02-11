package org.kacperski.shop.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductData {

    // == fields ==
    private static final double MIN_PRICE = 50;
    private static final double MAX_PRICE = 300;

    private final List<Product> products = new ArrayList<>();

    // == constructors ==
    public ProductData() {
        products.add(new Product("Czapka", generatePrice()));
        products.add(new Product("Szalik", generatePrice()));
        products.add(new Product("Rękawiczki", generatePrice()));
        products.add(new Product("Komin", generatePrice()));
    }

    // == private methods ==

    private static double generatePrice() {
        Random random = new Random();
        return Math.round((random.nextDouble() * (MAX_PRICE - MIN_PRICE) + MIN_PRICE) * 100.0) / 100.0;
    }

    // == public methods ==
    public void getProducts() {
        products.forEach(System.out::println);
    }

    public double getRazemNetto() {
        double razem = products.stream()
                .map(Product::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();

        return Math.round(razem * 100.0) / 100.0;
    }

    public double getRazemBrutto(double vatRate) {
        return Math.round((getRazemNetto() + (getRazemNetto() * vatRate))* 100.0) / 100.0;
    }

    public double getDiscount(double vatRate, double discount) {
        double brutto = getRazemBrutto(vatRate);
        return Math.round((brutto - (brutto*discount))* 100.0) / 100.0;
    }


}
