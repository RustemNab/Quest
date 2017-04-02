package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InterfaceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        final EditText etName = (EditText) findViewById(R.id.NameET);
        final Button Go = (Button) findViewById(R.id.Go_button);
    }
}
