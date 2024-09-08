package com.example.proiect.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.room.Room;

import com.example.proiect.data.AppDatabase;
import com.example.proiect.databinding.ActivityMainBinding;
import com.example.proiect.drawer.DrawerBaseActivity;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding activityMainBinding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor shpEditor;

    public AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setActivityTitle("Home");
        setupDatabase();

        sharedPreferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
        Log.e("ALL PREF", sharedPreferences.getAll().toString());

    }

    private void setupDatabase(){
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
    }


}