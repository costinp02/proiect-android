package com.example.proiect.products;

import com.example.proiect.data.tasks.InsertProductsTask;

import java.util.List;

public class ProductRepository {
    public static final ProductRepository INSTANCE = new ProductRepository();
    private List<Product> products;

    // Initialize with a list of pre-defined products
    public ProductRepository() {
        products = createDefaultProductList();
    }

    public List<Product> createDefaultProductList() {
        return List.of(
                new Product(1, "Heisenburger", 800, 8.99),
                new Product(2, "Blue Sky Chicken Tenders", 650, 6.99),
                new Product(3, "Saul's Spicy Chicken Wrap", 550, 7.49),
                new Product(4, "Los Pollos Salad Bowl", 400, 9.99),
                new Product(5, "Gus's Golden Wings", 900, 10.49),
                new Product(6, "Hank's Hearty Burrito", 1200, 11.99),
                new Product(7, "Skyler's Grilled Veggie Wrap", 300, 8.49),
                new Product(8, "Tuco's Loaded Nachos", 850, 9.99),
                new Product(9, "Walter's Breakfast Burrito", 600, 7.99),
                new Product(10, "The Skinny Pete Sundae", 400, 5.49)
        );
    }

    public void insertAllProducts(List<Product> productList, Runnable onFinish) {
        if (productList == null || onFinish == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        new InsertProductsTask(productList, onFinish).execute();

    }

}
