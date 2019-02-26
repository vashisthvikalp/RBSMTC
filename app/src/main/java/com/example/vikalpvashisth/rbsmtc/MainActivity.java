package com.example.vikalpvashisth.rbsmtc;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){
            //start profile activity here
            finish();
            startActivity(new Intent(this,ProfileActivity.class));
        }

        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == buttonSignIn){
            userLogin();
        }

    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            //stopping function execution
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            //stopping function execution
            return;
        }
        //if validations are ok
        //then we have to login our user
        Toast.makeText(getApplicationContext(),"Logging In!! please wait",Toast.LENGTH_SHORT).show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            //start profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}