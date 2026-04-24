package com.pluralsight;

import java.util.List;
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

    // PRODUCT SCREEN
    private void displayProductsScreen() {
        boolean inProducts = true;

        while (inProducts) {
            System.out.println("\n=== PRODUCTS ===");
            List<Product> products = inventory.getAllProducts();

            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }

            System.out.println("\nOptions:");
            System.out.println("S - Search Products");
            System.out.println("A - Add Product to Cart");
            System.out.println("B - Back to Home");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "S":
                    searchProducts();
                    break;
                case "A":
                    addProductToCart();
                    break;
                case "B":
                    inProducts = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void searchProducts() {
        System.out.println("\nSearch by:");
        System.out.println("1. Name");
        System.out.println("2. Department");
        System.out.println("3. Price");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();

        List<Product> results = null;

        switch (choice) {
            case "1":
                System.out.print("Enter name: ");
                results = inventory.searchByName(scanner.nextLine());
                break;
            case "2":
                System.out.print("Enter department: ");
                results = inventory.searchByDepartment(scanner.nextLine());
                break;
            case "3":
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                results = inventory.searchByPrice(price);
                break;
            default:
                System.out.println("Invalid search option.");
                return;
        }

        System.out.println("\n=== SEARCH RESULTS ===");
        if (results.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : results) {
                System.out.println(p);
            }
        }
    }
}
