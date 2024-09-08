package com.example.proiect.data.tasks;

import android.os.AsyncTask;

import com.example.proiect.data.AppController;
import com.example.proiect.products.Product;

import java.util.List;

public class InsertProductsTask extends AsyncTask<Void, Void, Void> {
    private final List<Product> products;
    private final Runnable onFinish;

    public InsertProductsTask(List<Product> products, Runnable onFinish) {
        this.products = products;
        this.onFinish = onFinish;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Insert all products into the database
        for (Product product : products) {
            AppController.getInstance()
                    .getAppDatabase()
                    .productDao()
                    .insert(product);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        onFinish.run();  // Trigger the callback when done
    }
}
