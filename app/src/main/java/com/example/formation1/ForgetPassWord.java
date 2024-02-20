package com.example.formation1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ForgetPassWord extends AppCompatActivity {
     private Button goToSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_word);
        goToSignIn = findViewById(R.id.goToSignInForget);

        goToSignIn.setOnClickListener(view -> {
            startActivity(new Intent(ForgetPassWord.this,SignInActivity.class));
        });

    }
}