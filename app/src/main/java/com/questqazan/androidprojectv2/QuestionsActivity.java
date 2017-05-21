package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionsActivity extends AppCompatActivity {

    String LOGIN;
    String TOKEN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Взятие логина после логинизации
        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");
        final String token = intent.getStringExtra("token");
        LOGIN = login;
        TOKEN = token;

        final CardView cd1 = (CardView) findViewById(R.id.cardView1);
        final CardView cd2 = (CardView) findViewById(R.id.cardView2);
        final CardView cd3 = (CardView) findViewById(R.id.cardView3);
        final CardView cd4 = (CardView) findViewById(R.id.cardView4);
        final CardView cd5 = (CardView) findViewById(R.id.cardView5);

        final TextView text1 = (TextView) findViewById(R.id.textView11);
        final TextView text2 = (TextView) findViewById(R.id.textView12);
        final TextView text3 = (TextView) findViewById(R.id.textView13);
        final TextView text4 = (TextView) findViewById(R.id.textView14);
        final TextView text5 = (TextView) findViewById(R.id.textView15);


        cd1.setVisibility(View.INVISIBLE);
        cd2.setVisibility(View.INVISIBLE);
        cd3.setVisibility(View.INVISIBLE);
        cd4.setVisibility(View.INVISIBLE);
        cd5.setVisibility(View.INVISIBLE);
        final String id1 = "1";
        final String id2 = "2";
        final String id3 = "3";
        final String id4 = "4";
        final String id5 = "5";
        final String[] answer1 = new String[1];
        final String[] answer2 = new String[1];
        final String[] answer3 = new String[1];
        final String[] answer4 = new String[1];
        final String[] answer5 = new String[1];
        final int[] price1 = new int[1];
        final int[] price2 = new int[1];
        final int[] price3 = new int[1];
        final int[] price4 = new int[1];
        final int[] price5 = new int[1];
        final int[] question1 = new int[1];
        final int[] question2 = new int[1];
        final int[] question3 = new int[1];
        final int[] question4 = new int[1];
        final int[] question5 = new int[1];


        /////Сделать подгрузку вопросов
        /////считать скриптом инфу о вопросах, на которые нет ответа
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        question1[0] = jsonResponse.getInt("question1");
                        question2[0] = jsonResponse.getInt("question2");
                        question3[0] = jsonResponse.getInt("question3");
                        question4[0] = jsonResponse.getInt("question4");
                        question5[0] = jsonResponse.getInt("question5");

                        if(question1[0] == 0)
                        {
                            // Подгрузили первый
                            Response.Listener<String> responseListener1 = new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if(success)
                                        {
                                            String question = jsonResponse.getString("question");
                                            answer1[0] = jsonResponse.getString("answer");
                                            price1[0] = jsonResponse.getInt("price");

                                            text1.setText(question);
                                        }
                                    }
                                    catch (JSONException e) {
                                        }
                                }
                            };

                            WriteQuestionRequest writeQuestionRequest1 = new WriteQuestionRequest(id1, responseListener1);
                            RequestQueue queue1 = Volley.newRequestQueue(QuestionsActivity.this);
                            queue1.add(writeQuestionRequest1);
                            cd1.setVisibility(View.VISIBLE);
                        }
                        if(question2[0] == 0)
                        {
                            // Подгрузили второй
                            Response.Listener<String> responseListener2 = new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if(success)
                                        {
                                            String question = jsonResponse.getString("question");
                                            answer2[0] = jsonResponse.getString("answer");
                                            price2[0] = jsonResponse.getInt("price");

                                            text2.setText(question);
                                        }
                                    }
                                    catch (JSONException e) {
                                        }
                                }
                            };

                            WriteQuestionRequest writeQuestionRequest2 = new WriteQuestionRequest(id2, responseListener2);
                            RequestQueue queue2 = Volley.newRequestQueue(QuestionsActivity.this);
                            queue2.add(writeQuestionRequest2);
                            cd2.setVisibility(View.VISIBLE);
                        }
                        if(question3[0] == 0)
                        {
                            // Подгрузили третий
                            Response.Listener<String> responseListener3 = new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if(success)
                                        {
                                            String question = jsonResponse.getString("question");
                                            answer3[0] = jsonResponse.getString("answer");
                                            price3[0] = jsonResponse.getInt("price");

                                            text3.setText(question);
                                        }
                                    }
                                    catch (JSONException e) {
                                    }
                                }
                            };

                            WriteQuestionRequest writeQuestionRequest3 = new WriteQuestionRequest(id3, responseListener3);
                            RequestQueue queue3 = Volley.newRequestQueue(QuestionsActivity.this);
                            queue3.add(writeQuestionRequest3);
                            cd3.setVisibility(View.VISIBLE);
                        }
                        if(question4[0] == 0)
                        {
                            // Подгрузили четвёртый
                            Response.Listener<String> responseListener4 = new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if(success)
                                        {
                                            String question = jsonResponse.getString("question");
                                            answer4[0] = jsonResponse.getString("answer");
                                            price4[0] = jsonResponse.getInt("price");

                                            text4.setText(question);
                                        }
                                    }
                                    catch (JSONException e) {
                                    }
                                }
                            };

                            WriteQuestionRequest writeQuestionRequest4 = new WriteQuestionRequest(id4, responseListener4);
                            RequestQueue queue4 = Volley.newRequestQueue(QuestionsActivity.this);
                            queue4.add(writeQuestionRequest4);
                            cd4.setVisibility(View.VISIBLE);
                        }
                        if(question5[0] == 0)
                        {
                            // Подгрузили пятый
                            Response.Listener<String> responseListener5 = new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success = jsonResponse.getBoolean("success");

                                        if(success)
                                        {
                                            String question = jsonResponse.getString("question");
                                            answer5[0] = jsonResponse.getString("answer");
                                            price5[0] = jsonResponse.getInt("price");

                                            text5.setText(question);
                                        }
                                    }
                                    catch (JSONException e) {
                                    }
                                }
                            };

                            WriteQuestionRequest writeQuestionRequest5 = new WriteQuestionRequest(id5, responseListener5);
                            RequestQueue queue5 = Volley.newRequestQueue(QuestionsActivity.this);
                            queue5.add(writeQuestionRequest5);
                            cd5.setVisibility(View.VISIBLE);
                        }
                    }
                }
                catch (JSONException e) {
                }
            }
        };

        QuestionRequest questionRequest = new QuestionRequest(login, responseListener);
        RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
        queue.add(questionRequest);
        //

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(QuestionsActivity.this, QuestionAnswerActivity.class);
                                intent.putExtra("login",login);
                                intent.putExtra("token",token);
                                intent.putExtra("id", id1);
                                intent.putExtra("Text_question", text1.getText());
                                intent.putExtra ("Answer",answer1[0]);
                                intent.putExtra("Price", price1[0]);
                                QuestionsActivity.this.startActivity(intent);
                            }
                            else
                            {
                                Toast y = Toast.makeText(getApplication(), "Please, reload application", Toast.LENGTH_LONG);
                                y.show();
                                finishAffinity();
                            }
                        } catch (JSONException e) {
                        }
                    }
                };
                ProvToken questionRequest = new ProvToken(login, token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
                queue.add(questionRequest);


            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(QuestionsActivity.this, QuestionAnswerActivity.class);
                                intent.putExtra("login",login);
                                intent.putExtra("token",token);
                                intent.putExtra("id", id2);
                                intent.putExtra("Text_question", text2.getText());
                                intent.putExtra("Answer",answer2[0]);
                                intent.putExtra("Price", price2[0]);
                                QuestionsActivity.this.startActivity(intent);
                            }
                            else
                            {
                                Toast y = Toast.makeText(getApplication(), "Please, reload application", Toast.LENGTH_LONG);
                                y.show();
                                finishAffinity();
                            }
                        } catch (JSONException e) {
                        }
                    }
                };
                ProvToken questionRequest = new ProvToken(login, token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
                queue.add(questionRequest);



            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(QuestionsActivity.this, QuestionAnswerActivity.class);
                                intent.putExtra("login",login);
                                intent.putExtra("token",token);
                                intent.putExtra("id", id3);
                                intent.putExtra("Text_question", text3.getText());
                                intent.putExtra("Answer",answer3[0]);
                                intent.putExtra("Price", price3[0]);
                                QuestionsActivity.this.startActivity(intent);
                            }
                            else
                            {
                                Toast y = Toast.makeText(getApplication(), "Please, reload application", Toast.LENGTH_LONG);
                                y.show();
                                finishAffinity();
                            }
                        } catch (JSONException e) {
                        }
                    }
                };
                ProvToken questionRequest = new ProvToken(login, token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
                queue.add(questionRequest);
            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(QuestionsActivity.this, QuestionAnswerActivity.class);
                                intent.putExtra("login",login);
                                intent.putExtra("token",token);
                                intent.putExtra("id", id4);
                                intent.putExtra("Text_question", text4.getText());
                                intent.putExtra("Answer",answer4[0]);
                                intent.putExtra("Price", price4[0]);
                                QuestionsActivity.this.startActivity(intent);
                            }
                            else
                            {
                                Toast y = Toast.makeText(getApplication(), "Please, reload application", Toast.LENGTH_LONG);
                                y.show();
                                finishAffinity();
                            }
                        } catch (JSONException e) {
                        }
                    }
                };
                ProvToken questionRequest = new ProvToken(login, token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
                queue.add(questionRequest);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent = new Intent(QuestionsActivity.this, QuestionAnswerActivity.class);
                                intent.putExtra("login",login);
                                intent.putExtra("token",token);
                                intent.putExtra("id", id5);
                                intent.putExtra("Text_question", text5.getText());
                                intent.putExtra("Answer",answer5[0]);
                                intent.putExtra("Price", price5[0]);
                                QuestionsActivity.this.startActivity(intent);
                            }
                            else
                            {
                                Toast y = Toast.makeText(getApplication(), "Please, reload application", Toast.LENGTH_LONG);
                                y.show();
                                finishAffinity();
                            }
                        } catch (JSONException e) {
                        }
                    }
                };
                ProvToken questionRequest = new ProvToken(login, token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(QuestionsActivity.this);
                queue.add(questionRequest);
            }
        });
    }

    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(QuestionsActivity.this, GameInterfaceActivity.class);
        intent.putExtra("login",LOGIN);
        intent.putExtra("token",TOKEN);
        QuestionsActivity.this.startActivity(intent);
    }
}
