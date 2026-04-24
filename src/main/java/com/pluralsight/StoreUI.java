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
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== ONLINE STORE ===");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayProductsScreen();
                    break;
                case "2":
                    displayCartScreen();
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for shopping!");
    }
}
