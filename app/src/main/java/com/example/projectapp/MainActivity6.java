package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity6 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private  EditText text;
    private Button btnReset;
    ProgressBar progressbarpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        text = findViewById(R.id.etResetEmail);
        btnReset = findViewById(R.id.resetPass);
        mAuth = FirebaseAuth.getInstance();
        progressbarpro = findViewById(R.id.progresspro);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = text.getText().toString();
                progressbarpro.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity6.this,"Link is send to your Email",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity6.this,MainActivity4.class));
                            progressbarpro.setVisibility(View.GONE);
                            finish();
                        }
                        else
                        {
//                            text.setError("");
//                            Toast.makeText(MainActivity6.this,"Failed",Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity6.this,"No such id exists Please Register first",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity6.this,MainActivity4.class));
                            progressbarpro.setVisibility(View.GONE);
                            finish();
                        }
                    }
                });
            }
        });
    }
}