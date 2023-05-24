package com.example.proiect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiect.databinding.ActivityUserBinding;

public class UserActivity extends DrawerBaseActivity {

    ActivityUserBinding activityUserBinding;
    SharedPreferences sharedPreferences;
    String loginType;
    TextView userNameTextView;
    Button logoutButton;
    UserRepo userRepo;

    String test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserBinding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(activityUserBinding.getRoot());
        setActivityTitle("Customers");

        userNameTextView = findViewById(R.id.user_name_textview);
        logoutButton = findViewById(R.id.logout_button);
        sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", MODE_PRIVATE);
//        Log.e("ALL PREF", sharedPreferences.getAll().toString());

        loginType = sharedPreferences.getString("login","");
        String userEmail = sharedPreferences.getString("email", "");
        Log.d("LOGIN EMAIL", userEmail);
        userRepo = new UserRepo();

        switch (loginType){
            case "local":

                Log.i("USEREMAIL", userEmail);
                for(User user: userRepo.users){
                    if(user.getEmail().equals(userEmail)){
                        userNameTextView.setText("Hi,\n" + user.getUsername());
                    }
                }
                break;

        }


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

    }

    public void Logout() {

            if (sharedPreferences == null)
                sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", MODE_PRIVATE);

            SharedPreferences.Editor shpEditor = sharedPreferences.edit();
            shpEditor.putString("email", "");
            shpEditor.putString("login", "");
            shpEditor.commit();

            Intent i = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(i);
            finish();

    }
}