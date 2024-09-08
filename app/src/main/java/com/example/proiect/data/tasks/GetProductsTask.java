package com.example.proiect.data.tasks;

import android.os.AsyncTask;

import com.example.proiect.data.AppController;
import com.example.proiect.products.Product;
import com.example.proiect.products.ProductDao;

import java.util.List;
import java.util.function.Consumer;

import kotlin.jvm.functions.Function1;

public class GetProductsTask extends AsyncTask<Void, Void, List<Product>> {
    private final ProductDao productDao;
    private final Function1<List<Product>, Void> onProductsFetched;

    public GetProductsTask(ProductDao productDao, Function1<List<Product>, Void> onProductsFetched) {
        this.productDao = productDao;
        this.onProductsFetched = onProductsFetched;
    }

    @Override
    protected List<Product> doInBackground(Void... voids) {
        // This runs in a background thread
        return productDao.getAll();
    }

    @Override
    protected void onPostExecute(List<Product> products) {
        // This runs on the UI thread
        onProductsFetched.invoke(products);
    }
}
