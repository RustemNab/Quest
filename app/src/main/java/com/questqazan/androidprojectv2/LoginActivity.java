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

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText LoginET = (EditText) findViewById(R.id.AnswerEt);
        final EditText PasswordET = (EditText) findViewById(R.id.PasswordEt);
        final Button signin = (Button) findViewById(R.id.Sign_In_button);
        final Button game = (Button) findViewById(R.id.button2);
        final TextView registr = (TextView) findViewById(R.id.RegistrTV);
        final String login_test = "test";

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this, GameInterfaceActivity.class);
                in.putExtra("login", login_test);
                LoginActivity.this.startActivity(in);
            }
        });

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

                //Логин
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            final int[] b_time = {0};
                            final int [] b_game = {0};
                            if(success)
                            {

                                //// Проверка времени
                                Response.Listener<String> responseListener1 = new Response.Listener<String>(){
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject jsonResponse = new JSONObject(response);
                                            boolean success = jsonResponse.getBoolean("success");

                                            if (success) {
                                                int year = jsonResponse.getInt("year");
                                                int mounth = jsonResponse.getInt("mounth");
                                                int day = jsonResponse.getInt("day");
                                                int hour_start = jsonResponse.getInt("hour_start");
                                                int hour_finish = jsonResponse.getInt("hour_finish");

                                                GregorianCalendar gcalendar = new GregorianCalendar();
                                                int mounthNow = gcalendar.get(Calendar.MONTH);
                                                int YearNow = gcalendar.get(Calendar.YEAR);
                                                int dayNow = gcalendar.get(Calendar.DAY_OF_MONTH);
                                                int hourNow = gcalendar.get(Calendar.HOUR_OF_DAY);

                                                if (YearNow == year) {
                                                    if (mounthNow == mounth) {
                                                        if (dayNow == day) {
                                                            if ((hourNow >= hour_start) && (hourNow < hour_finish)) {
                                                                ////данные о игре
                                                                Response.Listener<String> responseListener = new Response.Listener<String>()
                                                                {
                                                                    @Override
                                                                    public void onResponse(String response) {
                                                                        try{
                                                                            JSONObject jsonResponse = new JSONObject(response);
                                                                            boolean success = jsonResponse.getBoolean("success");

                                                                            if(success)
                                                                            {
                                                                                int game = jsonResponse.getInt("game");

                                                                                if(game != 0)
                                                                                {
                                                                                    String login =  LoginET.getText().toString();

                                                                                    Intent intent = new Intent(LoginActivity.this, GameInterfaceActivity.class);
                                                                                    intent.putExtra("login", login);
                                                                                    signin.setVisibility(View.VISIBLE);

                                                                                    LoginActivity.this.startActivity(intent);
                                                                                }
                                                                                else
                                                                                {
                                                                                    String login =  LoginET.getText().toString();

                                                                                    Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                                                                    intent.putExtra("login", login);
                                                                                    signin.setVisibility(View.VISIBLE);

                                                                                    LoginActivity.this.startActivity(intent);
                                                                                }
                                                                            }
                                                                        }
                                                                        catch (JSONException e) {
                                                                            Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                                                            y.show();
                                                                        }
                                                                    }
                                                                };

                                                                AllInfoRequest allInfoRequest = new AllInfoRequest(login, responseListener);
                                                                RequestQueue queue1 = Volley.newRequestQueue(LoginActivity.this);
                                                                queue1.add(allInfoRequest);
                                                                ////
                                                            }
                                                            else
                                                            {
                                                                String login =  LoginET.getText().toString();

                                                                Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                                                intent.putExtra("login", login);
                                                                signin.setVisibility(View.VISIBLE);

                                                                LoginActivity.this.startActivity(intent);
                                                            }
                                                        }
                                                        else
                                                        {
                                                            String login =  LoginET.getText().toString();

                                                            Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                                            intent.putExtra("login", login);
                                                            signin.setVisibility(View.VISIBLE);

                                                            LoginActivity.this.startActivity(intent);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        String login =  LoginET.getText().toString();

                                                        Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                                        intent.putExtra("login", login);
                                                        signin.setVisibility(View.VISIBLE);

                                                        LoginActivity.this.startActivity(intent);
                                                    }
                                                }
                                                else {
                                                    String login =  LoginET.getText().toString();

                                                    Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                                                    intent.putExtra("login", login);
                                                    signin.setVisibility(View.VISIBLE);

                                                    LoginActivity.this.startActivity(intent);
                                                }
                                            }
                                        }
                                        catch (JSONException e) {
                                            Toast y = Toast.makeText(getApplication(), "None Time", Toast.LENGTH_LONG);
                                            y.show();
                                            }
                                        }
                                    };

                                    TimeToStart timeToStart = new TimeToStart("1", responseListener1);
                                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                                    queue.add(timeToStart);
                                ////
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
