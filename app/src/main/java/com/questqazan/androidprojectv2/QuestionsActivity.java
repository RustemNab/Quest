package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Взятие логина после логинизации
        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");

        final CardView cd1 = (CardView) findViewById(R.id.cardView1);
        final CardView cd2 = (CardView) findViewById(R.id.cardView2);
        final CardView cd3 = (CardView) findViewById(R.id.cardView3);
        final CardView cd4 = (CardView) findViewById(R.id.cardView4);
        final CardView cd5 = (CardView) findViewById(R.id.cardView5);

        cd1.setVisibility(View.INVISIBLE);
        cd2.setVisibility(View.INVISIBLE);
        cd3.setVisibility(View.INVISIBLE);
        cd4.setVisibility(View.INVISIBLE);
        cd5.setVisibility(View.INVISIBLE);

        //считать скриптом инфу о вопросах, на которые нет ответа
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    Toast y = Toast.makeText(getApplication(), "Try", Toast.LENGTH_LONG);
                    y.show();
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        int question1 = jsonResponse.getInt("question1");
                        int question2 = jsonResponse.getInt("question2");
                        int question3 = jsonResponse.getInt("question3");
                        int question4 = jsonResponse.getInt("question4");
                        int question5 = jsonResponse.getInt("question5");

                        if(question1 == 0) cd1.setVisibility(View.VISIBLE);
                        if(question2 == 0) cd2.setVisibility(View.VISIBLE);
                        if(question3 == 0) cd3.setVisibility(View.VISIBLE);
                        if(question4 == 0) cd4.setVisibility(View.VISIBLE);
                        if(question5 == 0) cd5.setVisibility(View.VISIBLE);
                    }
                }
                catch (JSONException e) {
                    Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                    y.show();
                }
            }
        };

        QuestionRequest questionRequest = new QuestionRequest(login, responseListener);
        RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
        queue.add(questionRequest);
    }
}
