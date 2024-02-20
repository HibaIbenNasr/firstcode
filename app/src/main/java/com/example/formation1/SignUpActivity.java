package com.example.formation1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.formation1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpActivity extends AppCompatActivity {
    private TextView goToSignIn;
    private EditText nameet,emailet,phoneet,cinet,passwordet;
    private Button signupet;
    private String nameS,emailS,phoneS,cinS,passwordS;
    private static final String EMAIL_REGEX =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameet = findViewById(R.id.name);
        emailet = findViewById(R.id.email);
        phoneet = findViewById(R.id.phone);
        cinet = findViewById(R.id.cin);
        passwordet = findViewById(R.id.password);
        goToSignIn = findViewById(R.id.goToSignIn);
        signupet = findViewById(R.id.signup);

        goToSignIn.setOnClickListener(view -> {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        });

        firebaseAuth = FirebaseAuth.getInstance();
        signupet.setOnClickListener(v -> {
            if (validate()) {
               // Toast.makeText(this,"valide",Toast.LENGTH_SHORT          }
                firebaseAuth.createUserWithEmailAndPassword(emailS,passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                        @Override
                                public void onComplete(@NonNull Task<AuthResult> task){
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUpActivity.this, "account created", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignUpActivity.this, "account created", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
    });
}
    private boolean validate() {
            boolean result = false;
            nameS = nameet.getText().toString();
            emailS = emailet.getText().toString();
            phoneS = phoneet.getText().toString();
            cinS = cinet.getText().toString();
            passwordS = passwordet.getText().toString();
            if (nameS.isEmpty() || nameS.length() < 7) {
                nameet.setError("name not valide");
            } else if (!isValidEmail(emailS)) {
                emailet.setError("email not valide");
            } else if (phoneS.isEmpty() || phoneS.length() != 8) {
                phoneet.setError("phone not valide");
            } else if (cinS.isEmpty() || cinS.length() != 8) {
                cinet.setError(" cin not valide");
            } else if (passwordS.isEmpty() || passwordS.length()< 7) {
                passwordet.setError("password not valide");
            } else {
                result=true;
            }
            return result;
        }
            public  boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }}
