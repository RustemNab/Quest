package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistrActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        final EditText etName = (EditText) findViewById(R.id.NameET);
        final EditText etLogin = (EditText) findViewById(R.id.LoginET);
        final EditText etPassword = (EditText) findViewById(R.id.PasswordET);
        final EditText etAge = (EditText) findViewById(R.id.AgeET);

        final Button registr = (Button) findViewById(R.id.Registr_button);

    }
}
