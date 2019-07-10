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

public class RegisterActivity extends AppCompatActivity {
    EditText userName;
    EditText userLocation;
    EditText userEmail;
    EditText userPassword;
    EditText confirmPassword;
    Button signupButton;
    Button loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //initialization
        userName = (MaterialEditText) findViewById(R.id.editText_Name);
        userLocation = (MaterialEditText) findViewById(R.id.editText_Location);
        userEmail = (MaterialEditText) findViewById(R.id.editText_signupEmail);
        userPassword = (MaterialEditText) findViewById(R.id.editText_signupPassword);
        confirmPassword = (MaterialEditText) findViewById(R.id.editText_signupPassword2);
        signupButton = findViewById(R.id.btn_signup);
        loginLink = findViewById(R.id.btn_login);

        //setting sign up Button onclick Listener
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
            }
        });
        //setting login link onclick listener
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void registerUser(){

        String name = userName.getText().toString().trim();
        String location = userLocation.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        String password2 = confirmPassword.getText().toString().trim();

        //Check that no field is empty.
        if (userName.getText().length()<=0){
            Toast.makeText(this,"Please enter your Name",Toast.LENGTH_LONG).show();
        }
        else if (userLocation.getText().length()<=0){
            Toast.makeText(this,"Enter Location",Toast.LENGTH_LONG).show();
        }
        else if (userEmail.getText().length()<=0){
            Toast.makeText(this,"Enter Email",Toast.LENGTH_LONG).show();
        }
        else if (userPassword.getText().length()<=0){
            Toast.makeText(this,"Enter Password",Toast.LENGTH_LONG).show();
        }
        else if (confirmPassword.getText().length()<=0){
            Toast.makeText(this,"Confirm Password",Toast.LENGTH_LONG).show();
        }
        else {
                //declare and initialize sharedPreferences and editor
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("USER_CREDENTIALS",0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

                //saving user details to SharedPreferences using editor
            editor.putString("Name",name);
            editor.putString("Location",location);
            editor.putString("Email",email);
            editor.putString("Password",password);
            editor.putString("confirmPassword",password2);

            editor.commit();

            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"User Registered successfully",Toast.LENGTH_LONG).show();
        }
    }
}
