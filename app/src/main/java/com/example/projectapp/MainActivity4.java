package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {

    private EditText mEmail, mPass;
    private Button btnFregister;
    private Button signUpBtn;
    private Button btnForgotPass;
    private LinearLayout lala;
    ProgressBar progressin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mEmail = findViewById(R.id.EtFemail);
        mPass = findViewById(R.id.etFpassword);
        signUpBtn = findViewById(R.id.btnLogin);
        btnForgotPass = findViewById(R.id.btnForgot);
        progressin = findViewById(R.id.progressin);
        lala = findViewById(R.id.LaLa);

        mAuth = FirebaseAuth.getInstance();

        btnFregister = findViewById(R.id.btnFregister);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        btnFregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressin.setVisibility(View.VISIBLE);
                startActivity(new Intent(MainActivity4.this,MainActivity5.class));
                progressin.setVisibility(View.GONE);

            }
        });

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressin.setVisibility(View.VISIBLE);
                startActivity(new Intent(MainActivity4.this,MainActivity6.class));
                progressin.setVisibility(View.GONE);

            }
        });


    }

    public void loginUser()
    {
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            if(!pass.isEmpty())
            {
                progressin.setVisibility(View.VISIBLE);
                lala.setVisibility(View.INVISIBLE);
                mAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(MainActivity4.this,"Login Succesful",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity4.this,MainActivity7.class));
                        progressin.setVisibility(View.GONE);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity4.this,"Login Failed",Toast.LENGTH_LONG).show();
                        progressin.setVisibility(View.GONE);
                        lala.setVisibility(View.VISIBLE);
                    }
                });

            }
            else
            {
                mPass.setError("Empty fields");
            }
        }
        else if(email.isEmpty())
        {
            mEmail.setError("Empty fields");
        }
        else
        {
            mEmail.setError("Write correct mail");
        }
    }
}