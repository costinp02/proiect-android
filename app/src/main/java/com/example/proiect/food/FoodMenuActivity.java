package com.example.proiect.food;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.proiect.R;
import com.example.proiect.databinding.ActivityFoodMenuBinding;
import com.example.proiect.databinding.ActivityMainBinding;
import com.example.proiect.drawer.DrawerBaseActivity;
import com.example.proiect.products.ProductsRepo;

public class FoodMenuActivity extends DrawerBaseActivity {

    ActivityFoodMenuBinding activityFoodMenuBinding;
    RecyclerView recyclerView;
    ProductsRepo productsRepo = new ProductsRepo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFoodMenuBinding = ActivityFoodMenuBinding.inflate(getLayoutInflater());
        setContentView(activityFoodMenuBinding.getRoot());
        setActivityTitle("Menu");

        recyclerView = findViewById(R.id.food_menu_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        FoodAdapter foodAdapter = new FoodAdapter(FoodMenuActivity.this, productsRepo.products);
        recyclerView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
    }



}