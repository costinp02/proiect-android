package com.example.proiect.data;

import android.app.Application;

import androidx.room.Room;

import com.example.proiect.data.tasks.CheckAndInsertDefaultDataTask;

public final class AppController extends Application {

    private static AppController instance;
    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupDatabase();
        insertDefaultDataIfEmpty();
    }

    private void setupDatabase() {
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "proiectAndroid")
                .fallbackToDestructiveMigration()
                .build();
    }

    private void insertDefaultDataIfEmpty() {
        new CheckAndInsertDefaultDataTask().execute();
    }

    public AppDatabase getAppDatabase() {
        if (appDatabase == null){
            throw new IllegalStateException("appDatabase has not been initialized");
        }
        return  appDatabase;
    }

    public static AppController getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ApplicationController instance has not been initialized");
        }
        return instance;
    }
}
