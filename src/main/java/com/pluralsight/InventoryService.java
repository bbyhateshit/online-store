package com.pluralsight;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryService {
    private List<Product> products = new ArrayList<>();

    public void loadProducts(String filePath) {
        try (Scanner scanner = new Scanner(new File("src/main/resources/products.csv"))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Skip empty lines
                if (line.trim().isEmpty()) continue;
            }


        }
    }

}
