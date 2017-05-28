package com.questqazan.androidprojectv2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class GameInterfaceActivity extends AppCompatActivity {

    public String LOGIN;
    public String TOKEN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_interface);

        TextView tv = (TextView)findViewById(R.id.textView12);
        final Space questions = (Space) findViewById(R.id.go_questions);
        final Space tasks = (Space) findViewById(R.id.go_tasks);
        ImageView question_im = (ImageView) findViewById(R.id.imageView8);

        //Взятие логина и токена после логинизации
        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");
        final String token = intent.getStringExtra("token");
        final int finish = intent.getIntExtra("finish", 0);
        tv.setText(finish+":00");
        LOGIN = login;

        //Переход к вопросам
        question_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GameInterfaceActivity.this, QuestionsActivity.class);
                intent1.putExtra("login", login);
                intent1.putExtra("token", token);
                intent1.putExtra("finish",finish);
                GameInterfaceActivity.this.startActivity(intent1);
            }
        });


        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameInterfaceActivity.this, TasksActivity.class);
                GameInterfaceActivity.this.startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }
    public void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                GameInterfaceActivity.this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");

        quitDialog.setPositiveButton("Да", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                        } catch (JSONException e) {
                        }
                    }
                };
                ClearTokenRequest questionRequest = new ClearTokenRequest(LOGIN, responseListener);
                RequestQueue queue = Volley.newRequestQueue(GameInterfaceActivity.this);
                queue.add(questionRequest);
                finishAffinity();
            }
        });

        quitDialog.setNegativeButton("Нет", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

}


