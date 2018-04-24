package com.example.macstudent.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macstudent.DBUser;
import com.example.macstudent.User;

public class SignUpActivity extends AppCompatActivity {
    EditText userEmail;
    EditText userPassword;
    Button btnSignUp;
    EditText userConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        userEmail=(EditText) findViewById(R.id.userEmail);
        userPassword=(EditText)findViewById(R.id.userPassword);
        userConfirmPass=(EditText)findViewById(R.id.userConfrmpass);
        btnSignUp=(Button)findViewById(R.id.btnSign);



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()) {
                    User user = new User();
                    user.setEmail(userEmail.getText().toString());
                    user.setPassword(userPassword.getText().toString());

                    DBUser dbUser = new DBUser(SignUpActivity.this);
                    dbUser.insertUser(user);
                    dbUser.getAllUsers();
                    Intent in = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(SignUpActivity.this,"try again",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public boolean validate()
    {
        if(userPassword.getText().toString().length()!=0)
        {
            if(userPassword.getText().toString().equals(userConfirmPass.getText().toString()))
            {
           return true;
        }
        else
        {
            userConfirmPass.setError("Confirm password not matched");
        }}
        else
        {
           userPassword.setError("Enter password");
        }
        return false;

    }
}
