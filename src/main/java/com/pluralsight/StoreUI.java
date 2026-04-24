package com.pluralsight;

import java.util.Scanner;

public class StoreUI {
    private InventoryService inventory;
    private CartService cart;
    private Scanner scanner = new Scanner(System.in);

    public StoreUI(InventoryService inventory, CartService cart) {
        this.inventory = inventory;
        this.cart = cart;
    }
}
