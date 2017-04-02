package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etPassword = (EditText) findViewById(R.id.PasswordET);
        final EditText etLogin = (EditText) findViewById(R.id.LoginET);
        final Button signin = (Button) findViewById(R.id.Sign_In_button);
        final TextView registr = (TextView) findViewById(R.id.RegistrTV);

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrIntent = new Intent(LoginActivity.this, RegistrActivity.class);
                LoginActivity.this.startActivity(registrIntent);
            }
        });
    }
}
