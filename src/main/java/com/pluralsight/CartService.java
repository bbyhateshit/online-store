package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Product, Integer> cart = new HashMap<>();

// Add a product to the cart
    public void add(Product product) {
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }
}
