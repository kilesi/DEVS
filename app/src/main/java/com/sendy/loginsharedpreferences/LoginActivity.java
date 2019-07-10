package com.sendy.loginsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button btn_login;
    Button btn_signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            //initialization
        email = (MaterialEditText) findViewById(R.id.editText_loginEmail);
        password = (MaterialEditText) findViewById(R.id.editText_loginPassword);
        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);

        //setting onclick listeners to login and sign up buttons
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void loginUser(){
        String loginEmail = email.getText().toString().trim();
        String loginPassword = password.getText().toString().trim();

        if (loginEmail.equals("USER_CREDENTIALS") && loginPassword.equals("USER_CREDENTIALS")){
            Toast.makeText(this,"details match",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Wrong email or password",Toast.LENGTH_LONG).show();
        }

    }
}
