package com.example.proiect.products;

import java.util.List;

public class ProductsRepo {
    public List<Product> products;
    Product product1 = new Product(1, "Heisenburger", 800, 8.99);
    Product product2 = new Product(2, "Blue Sky Chicken Tenders", 650, 6.99);
    Product product3 = new Product(3, "Saul's Spicy Chicken Wrap", 550, 7.49);
    Product product4 = new Product(4, "Los Pollos Salad Bowl", 400, 9.99);
    Product product5 = new Product(5, "Gus's Golden Wings", 900, 10.49);
    Product product6 = new Product(6, "Hank's Hearty Burrito", 1200, 11.99);
    Product product7 = new Product(7, "Skyler's Grilled Veggie Wrap", 300, 8.49);
    Product product8 = new Product(8, "Tuco's Loaded Nachos", 850, 9.99);
    Product product9 = new Product(9, "Walter's Breakfast Burrito", 600, 7.99);
    Product product10 = new Product(10, "The Skinny Pete Sundae", 400, 5.49);

    public ProductsRepo() {
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
    }
}
