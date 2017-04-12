package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText LoginET = (EditText) findViewById(R.id.LoginEt);
        final EditText PasswordET = (EditText) findViewById(R.id.PasswordEt);
        final Button signin = (Button) findViewById(R.id.Sign_In_button);
        final TextView registr = (TextView) findViewById(R.id.RegistrTV);

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrIntent = new Intent(LoginActivity.this, RegistrActivity.class);
                LoginActivity.this.startActivity(registrIntent);
            }
        });

        signin.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String login = LoginET.getText().toString();
                final String password = PasswordET.getText().toString();
                signin.setVisibility(View.INVISIBLE);

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Please wait..")
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Toast t = Toast.makeText(getApplication(), "I try", Toast.LENGTH_SHORT);
                            //t.show();

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String login = jsonResponse.getString("login");
                                
                                Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                intent.putExtra("login", login);

                                LoginActivity.this.startActivity(intent);

                                //Toast y = Toast.makeText(getApplication(), "SUCCESS", Toast.LENGTH_SHORT);
                                //y.show();


                            }
                            else{
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                                builder1.setMessage("Login failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                                signin.setVisibility(View.VISIBLE);
                            }
                            
                        } catch (JSONException e) {
                            Toast y = Toast.makeText(getApplication(), "Catch", Toast.LENGTH_LONG);
                            y.show();
                            signin.setVisibility(View.VISIBLE);
                        }
                    }
                };
                
                LoginRequest loginRequest = new LoginRequest(login, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


            }
        });
    }
}
