package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InterfaceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        final EditText etName = (EditText) findViewById(R.id.NameET);
        final EditText etAge = (EditText) findViewById(R.id.AgeEt);
        final Button Go = (Button) findViewById(R.id.Go_button);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", -1);
        etName.setText(name);
        etAge.setText(age + "");

    }
}
