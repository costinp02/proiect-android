package com.example.proiect.food;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proiect.R;
import com.example.proiect.data.AppController;
import com.example.proiect.data.tasks.GetProductsTask;
import com.example.proiect.databinding.ActivityFoodMenuBinding;
import com.example.proiect.drawer.DrawerBaseActivity;
import com.example.proiect.products.ProductDao;
import com.example.proiect.products.ProductRepository;

public class FoodMenuActivity extends DrawerBaseActivity {

    ActivityFoodMenuBinding activityFoodMenuBinding;
    RecyclerView recyclerView;
    ProductRepository productRepository = new ProductRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFoodMenuBinding = ActivityFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(activityFoodMenuBinding.getRoot());
        setActivityTitle("Menu");

        recyclerView = findViewById(R.id.food_menu_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ProductDao productDao = AppController.getInstance().getAppDatabase().productDao();
        fetchProducts(productDao);
    }


    private void fetchProducts(ProductDao productDao) {
        // Use the AsyncTask to fetch products in the background
        new GetProductsTask(productDao, products -> {
            // Create and set the adapter once products are fetched
            FoodAdapter foodAdapter = new FoodAdapter(FoodMenuActivity.this, products);
            recyclerView.setAdapter(foodAdapter);
            foodAdapter.notifyDataSetChanged();
            return null; // This is required since the callback has a Void return type
        }).execute();
    }


}