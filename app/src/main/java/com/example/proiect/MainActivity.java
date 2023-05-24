package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.proiect.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding activityMainBinding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor shpEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setActivityTitle("Home");

        sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        Log.e("ALL PREF", sharedPreferences.getAll().toString());

    }


}