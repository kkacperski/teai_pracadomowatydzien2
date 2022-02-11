package org.kacperski.shop.service;

import org.kacperski.shop.model.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Start")
public class CartStartServiceImpl implements CartService {

    private final ProductData productData;

    @Autowired
    public CartStartServiceImpl(ProductData productData) {
        this.productData = productData;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void razem() {
        System.out.println("Lista produktów:");
        productData.getProducts();
        System.out.println();
        System.out.println("Wartość netto produktów w koszyku: " + productData.getRazemNetto() + " zł");
    }
}
