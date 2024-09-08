package com.example.proiect.data.tasks;

import android.os.AsyncTask;

import com.example.proiect.data.AppController;
import com.example.proiect.products.Product;
import com.example.proiect.products.ProductRepository;

import java.util.List;

public class CheckAndInsertDefaultDataTask extends AsyncTask<Void, Void, Boolean> {

    @Override
    protected Boolean doInBackground(Void... voids) {
        // Check if the product table is empty
        int productCount = AppController.getInstance()
                .getAppDatabase()
                .productDao()
                .getProductCount(); // Assumes a method getProductCount exists in ProductDao

        return productCount == 0; // Return true if database is empty
    }

    @Override
    protected void onPostExecute(Boolean isEmpty) {
        if (isEmpty) {
            // If database is empty, insert default data
            List<Product> defaultProducts = ProductRepository.INSTANCE.createDefaultProductList();
            new InsertProductsTask(defaultProducts, () -> {
                // Callback after insertion, you can handle post-insert logic here if needed
                System.out.println("Default products inserted successfully.");
            }).execute();
        }
    }
}