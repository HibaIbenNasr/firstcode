package com.example.formation1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {
    private TextView goToSignUp;
    private TextView goToForgetPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        goToSignUp= findViewById(R.id.goToSignUp);

        goToSignUp.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
        });


        goToForgetPassWord= findViewById(R.id.goToForgetPassWord);

        goToForgetPassWord.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this, ForgetPassWord.class));
        });
    }
}