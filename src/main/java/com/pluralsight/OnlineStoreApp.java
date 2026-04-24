package com.pluralsight;

public class OnlineStoreApp {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();
        inventory.loadProducts("src/main/resources/products.csv");

    }
}
