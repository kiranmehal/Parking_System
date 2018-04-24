package com.example.macstudent.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macstudent.DBUser;

public class LoginActivity extends AppCompatActivity {
    Button login;
    Button signUp;
    EditText userId;
    EditText userPass;
    CheckBox chkRememberMe;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. create shared preferences object
        myPref=getSharedPreferences("myPref",MODE_PRIVATE);
        chkRememberMe=(CheckBox)findViewById(R.id.chkRememberMe);

        login=(Button)findViewById(R.id.btnLogin);
         userId=(EditText)findViewById(R.id.userName);
         userPass=(EditText)findViewById(R.id.userPass);
         signUp=(Button)findViewById(R.id.btnsignUp);

        //2.get saved values from shared preferences
        String userid=myPref.getString("userId",null);
        String userp=myPref.getString("password",null);

        //3-set value to edit text
        if(userid!=null && userp!=null) {
            userId.setText(userid);
            userPass.setText(userp);
            chkRememberMe.setChecked(true);
        }
        else
        {
            chkRememberMe.setChecked(false);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(userId.getText())||userPass.getText().toString().length()==0) {
                userId.setError("Please enter username");
                }
                else {
                    DBUser dbUser = new DBUser(LoginActivity.this);

                    if (dbUser.isValidUser(userId.getText().toString(),  userPass.getText().toString()))

                    {
                        Toast.makeText(LoginActivity.this, "user logged successfully", Toast.LENGTH_LONG).show();
                        //4--get editor object
                        SharedPreferences.Editor editor = myPref.edit();
                        if (chkRememberMe.isChecked()) {
                            //5--save value to shared preferences using editor object
                            editor.putString("userId", userId.getText().toString());
                            editor.putString("password", userPass.getText().toString());
                            editor.apply();
                        } else {  //6--Remove values from shared preferences
                            editor.remove("userId");
                            editor.remove("password");
                        } //7--save changes permanently to shared prefrences
                        editor.apply();
                        Intent in = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(in);
                    } else {
                        Toast.makeText(LoginActivity.this,"UserID/Password Invalid",Toast.LENGTH_LONG).show();
                        // Intent in=new Intent(LoginActivity.this,NextAcitivity.class);
                        //startActivity(in);
                    }
                }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(in);
            }
        });


    }
}
