package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proiect.databinding.ActivityUserBinding;

public class UserActivity extends DrawerBaseActivity {

    ActivityUserBinding activityUserBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserBinding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(activityUserBinding.getRoot());
        setActivityTitle("Customers");

    }
}