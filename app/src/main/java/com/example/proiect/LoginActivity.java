package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail, userPass;
    private Button submitBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setVariable();
    }

    private void setVariable(){
        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEmail.getText().toString().isEmpty() || userPass.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please input valid info", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }

    private void initView(){
        userEmail = findViewById(R.id.login_edittext_email);
        userPass = findViewById(R.id.login_edittext_password);
        submitBttn = findViewById(R.id.login_button);
    }


}