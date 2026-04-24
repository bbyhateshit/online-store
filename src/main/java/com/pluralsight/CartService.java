package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Product, Integer> cart = new HashMap<>();

// Add a product to the cart
    public void add(Product product) {
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }
// Remove a product from the cart
    public void remove(Product product) {
        if (cart.containsKey(product)) {
            int qty = cart.get(product);

            if (qty > 1) {
                cart.put(product, qty - 1);
            } else {
                cart.remove(product);
            }
        }
    }
// Get all cart items
    public Map<Product, Integer> getItems() {
        return cart;
    }
// Calculate total price
    public double getTotal() {
        double total = 0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            total += p.getPrice() * qty;
        }

        return total;
    }
}
