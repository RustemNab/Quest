package com.questqazan.androidprojectv2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InterfaceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        final EditText etName = (EditText) findViewById(R.id.NameET);
        final EditText etPoint = (EditText) findViewById(R.id.PointET);
        final EditText etAllPoint = (EditText) findViewById(R.id.AllPointET);
        final Button Go = (Button) findViewById(R.id.Go_button);

        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");

        //Получение данных по логину
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        String name = jsonResponse.getString("name");
                        int point = jsonResponse.getInt("point");
                        int all_point = jsonResponse.getInt("all_point");
                        etName.setText(name);
                        etPoint.setText(point + "");
                        etAllPoint.setText(all_point + "");
                    }
                }
                catch (JSONException e) {
                }
            }
        };

        AllInfoRequest allInfoRequest = new AllInfoRequest(login, responseListener);
        RequestQueue queue = Volley.newRequestQueue(InterfaceActivity.this);
        queue.add(allInfoRequest);


        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(InterfaceActivity.this, GoToGameActivity.class);
                intent1.putExtra("login", login);

                InterfaceActivity.this.startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                InterfaceActivity.this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");

        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finishAffinity();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }
}
