package com.example.proiect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.proiect.databinding.ActivityUserBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class UserActivity extends DrawerBaseActivity {

    ActivityUserBinding activityUserBinding;
    SharedPreferences sharedPreferences;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
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

        gso =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        loginType = sharedPreferences.getString("login","");
        String userEmail = sharedPreferences.getString("email", "");
//        Log.d("LOGIN EMAIL", userEmail);
        userRepo = new UserRepo();

        switch (loginType){
            case "local":

//                Log.i("USEREMAIL", userEmail);
                for(User user: userRepo.users){
                    if(user.getEmail().equals(userEmail)){
                        userNameTextView.setText("Hi,\n" + user.getUsername());
                    }
                }
                break;

            case "google":
                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
                if(account != null){
                    String userName = account.getDisplayName();
                    userNameTextView.setText(userName);
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


        switch (loginType){
            case "local":
                if (sharedPreferences == null)
                    sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", MODE_PRIVATE);

                SharedPreferences.Editor shpEditor = sharedPreferences.edit();
                shpEditor.putString("email", "");
                shpEditor.putString("login", "");
                shpEditor.commit();

                Intent i = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;

            case "google":
                gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete( Task<Void> task) {
                        if (sharedPreferences == null)
                            sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", MODE_PRIVATE);

                        SharedPreferences.Editor shpEditor = sharedPreferences.edit();
                        shpEditor.putString("login", "");
                        shpEditor.commit();
                        finish();
                        startActivity(new Intent(UserActivity.this, LoginActivity.class));
                    }
                });

        }


    }
}