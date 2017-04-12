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
        final Button registr = (Button) findViewById(R.id.Registr_button);

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String login = etLogin.getText().toString();
                final String password = etPassword.getText().toString();
                registr.setVisibility(View.INVISIBLE);

                ///Проверка Логина
                Response.Listener<String> responseListener1 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
                        try {
                            JSONObject jsonResponse1 = new JSONObject(response1);
                            boolean success = jsonResponse1.getBoolean("success");

                            //Toast t = Toast.makeText(getApplication(), "I try prov", Toast.LENGTH_SHORT);
                            //t.show();

                            if((!success)&&(password.length()>=6)) {

                                /////Регистрация
                                Response.Listener<String> responseListener = new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject jsonResponse = new JSONObject(response);
                                            boolean success = jsonResponse.getBoolean("success");

                                            //Toast t = Toast.makeText(getApplication(), "I try registr", Toast.LENGTH_SHORT);
                                            //t.show();

                                            if (success) {
                                                Intent intent = new Intent(RegistrActivity.this, LoginActivity.class);
                                                RegistrActivity.this.startActivity(intent);
                                                //Toast y = Toast.makeText(getApplication(), "SUCCESS", Toast.LENGTH_LONG);
                                                //y.show();
                                            } else {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrActivity.this);
                                                builder.setMessage("Registr failed")
                                                        .setNegativeButton("Retry", null)
                                                        .create()
                                                        .show();
                                                registr.setVisibility(View.VISIBLE);

                                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                                y.show();
                                            }
                                        } catch (JSONException e) {
                                            Toast y = Toast.makeText(getApplication(), "Catch registr", Toast.LENGTH_LONG);
                                            y.show();
                                            registr.setVisibility(View.VISIBLE);
                                        }
                                    }
                                };

                                RegistrRequest registrRequest = new RegistrRequest(name, login, password, responseListener);
                                RequestQueue queue = Volley.newRequestQueue(RegistrActivity.this);
                                queue.add(registrRequest);

                            } else {

                                ////Имя занято
                                Toast y = Toast.makeText(getApplication(), "This LOGIN already used or PASSWORD is to short. Enter another", Toast.LENGTH_LONG);
                                y.show();
                                etName.setText("");
                                etLogin.setText("");
                                etPassword.setText("");
                                registr.setVisibility(View.VISIBLE);
                            }

                           } catch(JSONException e) {
                            Toast y = Toast.makeText(getApplication(), "Catch prov", Toast.LENGTH_SHORT);
                            y.show();
                            registr.setVisibility(View.VISIBLE);
                        }
                    }
                };
                ProvLoginRequest provRequest = new ProvLoginRequest(login, responseListener1);
                RequestQueue queue1 = Volley.newRequestQueue(RegistrActivity.this);
                queue1.add(provRequest);
            }
        });
    }
}
