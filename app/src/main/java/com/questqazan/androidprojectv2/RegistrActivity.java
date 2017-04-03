package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String login = etLogin.getText().toString();
                final String password = etPassword.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            Toast t = Toast.makeText(getApplication(), "I try", Toast.LENGTH_SHORT);
                            t.show();

                            if(success){
                                Intent intent = new Intent(RegistrActivity.this, LoginActivity.class);
                                RegistrActivity.this.startActivity(intent);
                                Toast y = Toast.makeText(getApplication(), "SUCCESS", Toast.LENGTH_LONG);
                                y.show();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrActivity.this);
                                builder.setMessage("Registr faied")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_SHORT);
                                y.show();
                            }
                        } catch (JSONException e) {
                            Toast y = Toast.makeText(getApplication(), "Catch", Toast.LENGTH_SHORT);
                            y.show();
                        }
                    }
                };


                RegistrRequest registrRequest = new RegistrRequest(name, login, password, age, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistrActivity.this);
                queue.add(registrRequest);

            }
        });
    }
}
