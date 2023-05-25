package com.example.proiect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail, userPass;
    private Button submitBttn;
    private ImageView googleLoginImage;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    SharedPreferences sharedPreferences;
    UserRepo userRepo = new UserRepo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = findViewById(R.id.login_edittext_email);
        userPass = findViewById(R.id.login_edittext_password);
        submitBttn = findViewById(R.id.login_button);
        googleLoginImage = (ImageView) findViewById(R.id.google_login_imageView);
        gso =new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(account != null){
            navigateToSecondActivity();
        }

        sharedPreferences = getSharedPreferences("myPreferences", 0);
        CheckLogin();

        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEmail.getText().toString().isEmpty() || userPass.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please input valid info", Toast.LENGTH_SHORT).show();
                }else{
                    DoLogin(userEmail.getText().toString(), userPass.getText().toString());
                }
            }
        });

        googleLoginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = gsc.getSignInIntent();
                startActivityForResult(signInIntent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void CheckLogin() {
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences("myPreferences", 0);

        String userEmail = sharedPreferences.getString("email", "");

        if (userEmail != null && !userEmail.equals("")) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void DoLogin(String userEmail, String password) {
            boolean foundUser = false;
            for (User user : userRepo.users){
                if (user.getPassword().equals(password) && user.getEmail().equals(userEmail)){  //see if there is user with input password
                    foundUser = true;
                    if (sharedPreferences == null)
                        sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", 0);

                    SharedPreferences.Editor shpEditor = sharedPreferences.edit();
                    shpEditor.putString("email", userEmail); //use email as sharedpreferences key and store it
                    shpEditor.putString("login", "local");  // local login using shared preferences was used
                    shpEditor.commit();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class); //perform login and start main activity
                    startActivity(i);
                    finish();
                }
            }
            if (!foundUser){
                Toast.makeText(LoginActivity.this, "Please input valid info", Toast.LENGTH_SHORT).show();
            }


    }

    void navigateToSecondActivity(){
        if (sharedPreferences == null)
            sharedPreferences = getApplicationContext().getSharedPreferences("myPreferences", 0);

        SharedPreferences.Editor shpEditor = sharedPreferences.edit();
        shpEditor.putString("login","google");
        shpEditor.commit();
        finish();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

}